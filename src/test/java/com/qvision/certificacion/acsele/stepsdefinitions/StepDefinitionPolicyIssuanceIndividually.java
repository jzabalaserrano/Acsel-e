package com.qvision.certificacion.acsele.stepsdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.qvision.certificacion.acsele.drivers.Driver;
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

public class StepDefinitionPolicyIssuanceIndividually {
	@Steps(shared = true)
	private Actor actor = Actor.named("the");

	@Managed
	private WebDriver browser;

	@Before
	public void setUp() {
		OnStage.setTheStage(Cast.ofStandardActors());
	};

	@Given("As a collaborator of alfa insurance, I would like to issue policies.")
	public void asACollaboratorOfAlfaInsuranceIWouldLikeToIssuePolicies() throws FileNotFoundException, IOException {
		// Write code here that turns the phrase above into concrete actions
		// El actor puede abrir el navegador.
		ExcelToData.readFile(PolicyIssuanceParserUserInterface.RUTA_EXCELDATA_PARSER_INDIVIDUALLYPOLICY);
		String[][] data = ExcelToData.getDataExcel();
		for (int i = 1; i < ExcelToData.filas; i++) {
			Driver.web();
			String environment = data[i][0];
			switch (environment) {
			case "PRE_PROD184":
				theActorCalled(actor.getName())
						.whoCan(BrowseTheWeb.with(Driver.inThePage(PolicyIssuanceParserUserInterface.PRE_PROD184)));
				theActorInTheSpotlight().attemptsTo(SuccessfulLogin.withTheUser());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
//			Driver.inTheStage().close();
		}

	}

	@When("Login into the application and create policies.")
	public void loginIntoTheApplicationAndCreatePolicies() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("The policies Individually was successfully created.")
	public void thePoliciesIndividuallyWasSuccessfullyCreated() {
		// Write code here that turns the phrase above into concrete actions

	}

}
