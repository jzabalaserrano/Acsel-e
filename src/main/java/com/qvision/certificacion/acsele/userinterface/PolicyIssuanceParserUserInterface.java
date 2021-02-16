package com.qvision.certificacion.acsele.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class PolicyIssuanceParserUserInterface {

	public static final String PRE_PROD184 = "https://10.61.57.184:7022/WController";
	public static final String PRE_PROD185 = "https://10.61.57.185:7022/WController";
	public static final String QA_EVOL = "https://10.61.57.242:9446/WController";
	public static final String QA_ADL = "https://10.61.57.243:9446/WController/";
	public static final String RUTA_EXCELDATA_PARSER_INDIVIDUALLYPOLICY = "src/test/resources/datadriven/PolicyIssuanceParserIndividually.xlsx";
	public static final String RUTA_EXCELDATA_PARSER_MASSIVEPOLICY = "src/test/resources/datadriven/PolicyIssuanceParserMassive.xlsx";
	public static final String ID_DYNAMICPARSERPARSER = "157720";
	public static final String ID_DYNAMICPARSERPROCCESOR = "157820";

	/*****************************************
	 * Login
	 *****************************************/

	public static final Target INPUT_USER = Target.the("Input to type the user")
			.locatedBy("//input[@name='SecurityLogin']");
	public static final Target INPUT_PASSWORD = Target.the("Input to type the password")
			.locatedBy("//input[@name='SecurityPassword']");
	public static final Target BUTTON_SUBMIT_LOGIN = Target.the("button to enter the application ")
			.locatedBy("//input[@name='SecuritySubmit']");
	public static final Target MSG_SUBMIT_LOGIN = Target.the("alert to validate that there is an open session")
			.locatedBy("//p[contains(text(),'¿Desea cerrar dicha session y crear una nueva?')]");
	public static final Target BUTTON_MSG_SUBMIT_LOGIN = Target.the("alert to validate that there is an open session")
			.locatedBy("//input[@name='SecuritySubmit']");

	/*****************************************
	 * Massive Policy
	 *****************************************/

	public static final Target MAIN_MENU_MAINTENANCE = Target.the("Option in maintenance")
			.locatedBy("(//div[contains(text(),'Mantenimiento')])[1]");
	public static final Target MAIN_MENU_MAINTENANCE_TASKMANAGER = Target.the("Option in maintenance for task manager")
			.locatedBy("//div[contains(text(),'Administrador de Tareas')]");
	public static final Target MAIN_MENU_MAINTENANCE_TASKMANAGER_TASKEXECUTIONVAADIN = Target
			.the("Option in maintenance for task manager to execution tasks vaadin")
			.locatedBy("//div[contains(text(),'Ejecución de tareas (Vaadin)')]");
	public static final Target MAIN_MENU_MAINTENANCE_TASKMANAGER_CONSULTEXECUTION = Target
			.the("Maintenance option for task manager for Mass Process Execution Consultation ")
			.locatedBy("//div[contains(text(),'Consulta de Ejecución de Procesos Masivos')]");

	/*****************************************
	 * Dynamic parser parser
	 *****************************************/

	public static final Target INPUT_DYNAMICPARSERPARSER_IDPROCESS = Target
			.the("Input to type the ID of Dynamic parser parser")
			.locatedBy("//div[@class='v-slot v-slot-pagedtable']//input[1]");
	public static final Target BUTTON_DYNAMICPARSERPARSER_IDPROCESS = Target
			.the("Button to select the ID of Dynamic parser parser")
			.locatedBy("//div[contains(text(),'DynamicParserParser')]");
	public static final Target BUTTON_DYNAMICPARSERPARSER_MODIFYPARAMETERS = Target
			.the("Button to select the ID of Dynamic parser parser").locatedBy("//span[contains(text(),'Parámetros')]");
	public static final Target INPUT_DYNAMICPARSERPARSER_DIRECTORY = Target.the("Input to type the directory")
			.locatedBy("//input[@id='directory']");
	public static final Target INPUT_DYNAMICPARSERPARSER_LOG = Target.the("Input to type the log")
			.locatedBy("//input[@id='logdirectory']");
	public static final Target INPUT_DYNAMICPARSERPARSER_CONFIGURATION = Target.the("Input to type the configuration")
			.locatedBy("//input[@id='configuration']");
	public static final Target INPUT_DYNAMICPARSERPARSER_FILENAME = Target.the("Input to type the filename")
			.locatedBy("//input[@id='filename']");
	public static final Target INPUT_DYNAMICPARSERPARSER_SHEETEXCEL = Target.the("Input to type the sheetExcel")
			.locatedBy("//input[@id='sheetExcel']");
	public static final Target BUTTON_DYNAMICPARSERPARSER_SAVE = Target.the("button to save the parameters")
			.locatedBy("//span[contains(text(),'Aceptar')]");
	public static final Target BUTTON_DYNAMICPARSERPARSER_EXECUTEJOB = Target.the("button to execute the job")
			.locatedBy("//span[contains(text(),'Ejecutar')]");
	public static final Target BUTTON_DYNAMICPARSERPARSER_EXECUTEJOB_CONFIRM = Target.the("button to confirm for execute the job")
			.locatedBy("//span[contains(text(),'Aceptar')]");
	

	/*****************************************
	 * Dynamic parser Processor
	 *****************************************/

	public static final Target BUTTON_DYNAMICPARSERPROCESSOR_IDPROCESS = Target
			.the("Button to select the ID of Dynamic parser parser")
			.locatedBy("//div[contains(text(),'DynamicParserProcessor')]");
	public static final Target INPUT_DYNAMICPARSERPROCESSOR_FILENAME = Target.the("Input to type the filename")
			.locatedBy("//input[@id='filename']");
	public static final Target INPUT_DYNAMICPARSERPROCESSOR_CONFIGURATION = Target
			.the("Input to type the configuration").locatedBy("//input[@id='configuration']");
	public static final Target INPUT_DYNAMICPARSERPROCESSOR_SHEETEXCEL = Target.the("Input to type the sheetExcel")
			.locatedBy("//input[@id='sheetExcel']");
	public static final Target BUTTON_DYNAMICPARSERPROCESSOR_SAVE = Target.the("button to save the parameters")
			.locatedBy("//span[contains(text(),'Aceptar')]");

	/*****************************************
	 * Mass Process Execution Consultation
	 *****************************************/
	public static final Target INPUT_MASSPROCESSCONSULTATION_FILENAME = Target.the("input to type the file name")
			.locatedBy("//div[@id='Table']//input[1]");
	public static final Target ROW_TABLE_MASSPROCCESSCONSULTATION_FILENAME = Target.the("input to type the file name")
			.locatedBy("//div[contains(text(),'{0}')]");
	public static final Target BUTTON_MASSPROCESSCONSULTATION_CONSULT = Target.the("select the row with the file name")
			.locatedBy(
					"//body[contains(@class,'v-generated-body v-sa v-ch v-webkit v-win')]/div[@id='WControllervaadinservlet-1750660287']/div[@class='v-ui v-scrollable']/div[@class='v-verticallayout v-layout v-vertical v-widget v-has-width']/div[@class='v-slot v-align-center']/div[@class='v-panel v-widget v-has-width']/div[@class='v-panel-content v-scrollable']/div[@class='v-verticallayout v-layout v-vertical v-widget v-subPanel-content v-verticallayout-v-subPanel-content v-has-width v-margin-top v-margin-right v-margin-bottom v-margin-left']/div[@class='v-slot v-align-center v-align-bottom']/div[@class='v-horizontallayout v-layout v-horizontal v-widget']/div[1]/div[1]/span[1]");
	public static final Target PROCESSNUMB_MASSPROCCESSCONSULTATION = Target.the("the records processed").locatedBy(
			"//div[@class='v-verticallayout v-layout v-vertical v-widget v-subPanel-content v-verticallayout-v-subPanel-content v-has-width v-margin-top v-margin-right v-margin-bottom v-margin-left']//div[1]//div[1]//div[7]//div[1]//div[1]//div[3]//div[1]");
	public static final Target FAILED_MASSPROCCESSCONSULTATION = Target.the("the records failed").locatedBy(
			"//div[@class='v-verticallayout v-layout v-vertical v-widget v-has-width v-margin-top v-margin-bottom']//div[3]//div[1]//div[1]//div[3]//div[1]");

}
