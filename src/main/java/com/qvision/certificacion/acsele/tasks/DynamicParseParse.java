package com.qvision.certificacion.acsele.tasks;

import org.openqa.selenium.Keys;

import com.qvision.certificacion.acsele.drivers.Driver;
import com.qvision.certificacion.acsele.interactions.WaitToLoad;
import com.qvision.certificacion.acsele.userinterface.PolicyIssuanceParserUserInterface;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Step;

public class DynamicParseParse implements Performable, Task {
	private String directory;
	private String configuration;
	private String fileName;
	private String sheetExcel;
	private String idDynamicparserparser;
	private String log;
	public static String mainPage = "";
	public static String parserPage = "";

	public DynamicParseParse(String directory, String configuration, String fileName, String sheetExcel,
			String idDynamicparserparser, String log) {
		this.directory = directory;
		this.configuration = configuration;
		this.fileName = fileName;
		this.sheetExcel = sheetExcel;
		this.idDynamicparserparser = idDynamicparserparser;
		this.log = log;
	}

	public static DynamicParse DynamicParseData() {
		return new DynamicParse();
	}

	@SuppressWarnings("unused")
	@Override
	@Step("the actor tries to execute the parse parse job ")
	@Screenshots(forEachAction = true)
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		actor.attemptsTo(Click.on(PolicyIssuanceParserUserInterface.MAIN_MENU_MAINTENANCE),
				Click.on(PolicyIssuanceParserUserInterface.MAIN_MENU_MAINTENANCE_TASKMANAGER),
				Click.on(PolicyIssuanceParserUserInterface.MAIN_MENU_MAINTENANCE_TASKMANAGER_TASKEXECUTIONVAADIN));

		String winHandleBefore = Driver.inTheStage().getWindowHandle();
		mainPage = winHandleBefore;
		for (String winHandle : Driver.inTheStage().getWindowHandles()) {
			Driver.inTheStage().switchTo().window(winHandle);
		}
		String winHandleAfter = Driver.inTheStage().getWindowHandle();
		parserPage = winHandleAfter;

		actor.attemptsTo(
				Enter.theValue(idDynamicparserparser)
						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_IDPROCESS).thenHit(Keys.TAB),
				WaitToLoad.theMiliSeconds(1000),
				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_IDPROCESS),
				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_MODIFYPARAMETERS),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_DIRECTORY),
				Enter.theValue(directory).into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_DIRECTORY),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_LOG),
				Enter.theValue(log).into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_LOG),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_CONFIGURATION),
				Enter.theValue(configuration)
						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_CONFIGURATION),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_FILENAME),
				Enter.theValue(fileName).into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_FILENAME),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_SHEETEXCEL),
				Enter.theValue(sheetExcel)
						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_SHEETEXCEL));
//				,Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_SAVE),
//				WaitToLoad.theMiliSeconds(3000),
//				Enter.theValue(idDynamicparserparser)
//						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_IDPROCESS).thenHit(Keys.TAB),
//				WaitToLoad.theMiliSeconds(1000),
//				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_IDPROCESS),
//				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_EXECUTEJOB),
//				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_EXECUTEJOB_CONFIRM),
//				WaitToLoad.theMiliSeconds(180000));

	}

	public static class DynamicParse {
		public DynamicParse() {

		}

		public Performable findData(String directory, String configuration, String fileName, String sheetExcel,
				String idDynamicparserparser, String log) {
			return Instrumented.instanceOf(DynamicParseParse.class).withProperties(directory, configuration, fileName,
					sheetExcel, idDynamicparserparser, log);
		}
	}
}
