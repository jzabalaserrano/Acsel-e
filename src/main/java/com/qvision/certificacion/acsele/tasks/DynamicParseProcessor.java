package com.qvision.certificacion.acsele.tasks;

import org.openqa.selenium.Keys;

import com.qvision.certificacion.acsele.drivers.Driver;
import com.qvision.certificacion.acsele.interactions.WaitToLoad;
import com.qvision.certificacion.acsele.userinterface.PolicyIssuanceParserUserInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class DynamicParseProcessor implements Task {
	private String directory, configuration, fileName, sheetExcel, idDynamicparserparse, log;

	/**
	 * @param directory
	 * @param configuration
	 * @param fileName
	 * @param sheetExcel
	 */
	public DynamicParseProcessor(String directory, String configuration, String fileName, String sheetExcel,
			String idDynamicparserparse, String log) {
		this.directory = directory;
		this.configuration = configuration;
		this.fileName = fileName;
		this.sheetExcel = sheetExcel;
		this.idDynamicparserparse = idDynamicparserparse;
		this.log = log;
	}

	@SuppressWarnings("unused")
	@Override
	@Step("the actor tries to modify the parameters in the job parseproccessor and execute it")
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub

		for (String winHandle : Driver.inTheStage().getWindowHandles()) {
			Driver.inTheStage().switchTo().window(DynamicParseParse.parserPage);
		}

		fileName = directory + fileName;
		System.out.println(fileName);
		actor.attemptsTo(WaitToLoad.theMiliSeconds(4000),
				Enter.theValue(idDynamicparserparse)
						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_IDPROCESS).thenHit(Keys.TAB),
				WaitToLoad.theMiliSeconds(1000),
				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPROCESSOR_IDPROCESS),
				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_MODIFYPARAMETERS),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPROCESSOR_FILENAME),
				Enter.theValue(fileName).into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPROCESSOR_FILENAME),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPROCESSOR_CONFIGURATION),
				Enter.theValue(configuration)
						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPROCESSOR_CONFIGURATION),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_LOG),
				Enter.theValue(log).into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_LOG),
				Clear.field(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPROCESSOR_SHEETEXCEL),
				Enter.theValue(sheetExcel)
						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPROCESSOR_SHEETEXCEL));
//				,Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_SAVE),
//				WaitToLoad.theMiliSeconds(3000),
//				Enter.theValue(idDynamicparserparse)
//						.into(PolicyIssuanceParserUserInterface.INPUT_DYNAMICPARSERPARSER_IDPROCESS).thenHit(Keys.TAB),
//				WaitToLoad.theMiliSeconds(1000),
//				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_IDPROCESS),
//				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_EXECUTEJOB),
//				Click.on(PolicyIssuanceParserUserInterface.BUTTON_DYNAMICPARSERPARSER_EXECUTEJOB_CONFIRM),
//				WaitToLoad.theMiliSeconds(180000));

	}

	public static DynamicParseProcessor withTheData(String directory, String configuration, String fileName,
			String sheetExcel, String idDynamicparserparse, String log) {
		return Tasks.instrumented(DynamicParseProcessor.class, directory, configuration, fileName, sheetExcel,
				idDynamicparserparse, log);
	}

}
