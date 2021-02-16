package com.qvision.certificacion.acsele.tasks;

import static io.vavr.Predicates.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.qvision.certificacion.acsele.drivers.Driver;
import com.qvision.certificacion.acsele.interactions.WaitToLoad;
import com.qvision.certificacion.acsele.userinterface.PolicyIssuanceParserUserInterface;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;

public class MassProcessExecutionConsultation implements Performable, Task {

	private String fileName;
	private String rowProcess;

	public MassProcessExecutionConsultation(String fileName, String rowProcess) {
		this.fileName = fileName;
		this.rowProcess = rowProcess;
	}

	public static MassProccess MassProcessConsultation() {
		return new MassProccess();
	}

	@Override
	@Step("the actor tries to enter the application ")
	@Screenshots(forEachAction = true)
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub

		Driver.inTheStage().switchTo().window(DynamicParseParse.mainPage);
		actor.attemptsTo(Click.on(PolicyIssuanceParserUserInterface.MAIN_MENU_MAINTENANCE),
				Click.on(PolicyIssuanceParserUserInterface.MAIN_MENU_MAINTENANCE_TASKMANAGER),
				Click.on(PolicyIssuanceParserUserInterface.MAIN_MENU_MAINTENANCE_TASKMANAGER_CONSULTEXECUTION),
				WaitToLoad.theMiliSeconds(3000));

		for (String winHandle : Driver.inTheStage().getWindowHandles()) {
			if (winHandle != DynamicParseParse.mainPage && winHandle != DynamicParseParse.parserPage) {
				Driver.inTheStage().switchTo().window(winHandle);
			}

		}

		actor.attemptsTo(Click.on(PolicyIssuanceParserUserInterface.INPUT_MASSPROCESSCONSULTATION_FILENAME),
				Enter.theValue(fileName).into(PolicyIssuanceParserUserInterface.INPUT_MASSPROCESSCONSULTATION_FILENAME)
						.thenHit(Keys.TAB),
				Click.on(PolicyIssuanceParserUserInterface.ROW_TABLE_MASSPROCCESSCONSULTATION_FILENAME.of(fileName)),
				Click.on(PolicyIssuanceParserUserInterface.BUTTON_MASSPROCESSCONSULTATION_CONSULT));

		int numberProcessCurrent = 0;
		while (Integer.parseInt(rowProcess) > numberProcessCurrent) {
			numberProcessCurrent = Integer.parseInt(Driver.inTheStage().findElement(By.xpath(
					"//div[@class='v-verticallayout v-layout v-vertical v-widget v-subPanel-content v-verticallayout-v-subPanel-content v-has-width v-margin-top v-margin-right v-margin-bottom v-margin-left']//div[1]//div[1]//div[7]//div[1]//div[1]//div[3]//div[1]"))
					.getText());
			System.out.println("Obtenido: " + numberProcessCurrent);
			System.out.println("Esperado: " + rowProcess);

			if (Integer.parseInt(rowProcess) == numberProcessCurrent) {
				break;
			} else {
				actor.attemptsTo(WaitToLoad.theMiliSeconds(60000));
				Driver.inTheStage().navigate().refresh();
			}

		}
		actor.should(
				seeThat(TheTarget.textOf(PolicyIssuanceParserUserInterface.PROCESSNUMB_MASSPROCCESSCONSULTATION),
						is(rowProcess)),
				seeThat(TheTarget.textOf(PolicyIssuanceParserUserInterface.FAILED_MASSPROCCESSCONSULTATION), is("0")));

	}

	public static class MassProccess {
		public MassProccess() {

		}

		public Performable withTheData(String fileName, String rowProcess) {
			return Instrumented.instanceOf(MassProcessExecutionConsultation.class).withProperties(fileName, rowProcess);
		}
	}
}
