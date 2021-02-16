package com.qvision.certificacion.acsele.stepsdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qvision.certificacion.acsele.drivers.Driver;
import com.qvision.certificacion.acsele.tasks.DynamicParseParse;
import com.qvision.certificacion.acsele.tasks.DynamicParseProcessor;
import com.qvision.certificacion.acsele.tasks.MassProcessExecutionConsultation;
import com.qvision.certificacion.acsele.tasks.SuccessfulLogin;
import com.qvision.certificacion.acsele.userinterface.PolicyIssuanceParserUserInterface;
import com.qvision.certificacion.acsele.utils.ExcelToData;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class StepDefinitionPolicyIssuanceMassive {
	@Steps(shared = true)
	private Actor actor = Actor.named("the");

	@Managed
	private WebDriver browser;

	@Before
	public void setUp() {
		OnStage.setTheStage(Cast.ofStandardActors());
	};

	public static String[][] data;

	@Given("^As a partner of Alpha insurance, I would like to issue policies massively\\.$")
	public void asAPartnerOfAlphaInsuranceIWouldLikeToIssuePoliciesMassively()
			throws FileNotFoundException, IOException {
		// Write code here that turns the phrase above into concrete actions
		// El actor puede abrir el navegador.
		ExcelToData.readFile(PolicyIssuanceParserUserInterface.RUTA_EXCELDATA_PARSER_MASSIVEPOLICY);
		data = ExcelToData.getDataExcel();
		Driver.web();
		String environment = data[1][0];
		switch (environment) {
		case "PRE_PROD184":
			theActorCalled(actor.getName())
					.whoCan(BrowseTheWeb.with(Driver.inThePage(PolicyIssuanceParserUserInterface.PRE_PROD184)));
			break;
		case "PRE_PROD185":
			theActorCalled(actor.getName())
					.whoCan(BrowseTheWeb.with(Driver.inThePage(PolicyIssuanceParserUserInterface.PRE_PROD185)));
			break;
		case "QA_EVOL":
			theActorCalled(actor.getName())
					.whoCan(BrowseTheWeb.with(Driver.inThePage(PolicyIssuanceParserUserInterface.QA_EVOL)));
			break;
		case "QA_ADL":
			theActorCalled(actor.getName())
					.whoCan(BrowseTheWeb.with(Driver.inThePage(PolicyIssuanceParserUserInterface.QA_ADL)));
			break;

		default:
			System.out.println("Opción seleccionada, no es valida");
			break;
		}
		theActorInTheSpotlight().attemptsTo(SuccessfulLogin.withTheUser());

	}

	@When("^Issue policies in bulk after logging into the app\\.$")
	public void issuePoliciesInBulkAfterLoggingIntoTheApp() {
		// Write code here that turns the phrase above into concrete actions
		theActorInTheSpotlight().attemptsTo(
				DynamicParseParse.DynamicParseData().findData(data[1][1], data[1][2], data[1][3], data[1][4],
						PolicyIssuanceParserUserInterface.ID_DYNAMICPARSERPARSER, data[1][6]),
				MassProcessExecutionConsultation.MassProcessConsultation().withTheData(data[1][3], data[1][5]),
				DynamicParseProcessor.withTheData(data[1][1], data[1][2], data[1][3], data[1][4],
						PolicyIssuanceParserUserInterface.ID_DYNAMICPARSERPROCCESOR, data[1][6]));
	}

	@Then("^The policies massively was successfully created\\.$")
	public void thePoliciesMassivelyWasSuccessfullyCreated() {
		// Write code here that turns the phrase above into concrete actions

	}

}
