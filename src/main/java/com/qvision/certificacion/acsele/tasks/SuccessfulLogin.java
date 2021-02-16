package com.qvision.certificacion.acsele.tasks;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import com.qvision.certificacion.acsele.drivers.Driver;
import com.qvision.certificacion.acsele.interactions.WaitToLoad;
import com.qvision.certificacion.acsele.userinterface.PolicyIssuanceParserUserInterface;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SuccessfulLogin implements Task {
	private static String user;
	private static String password;

	/**
	 * @param user
	 * @param password
	 */
	@SuppressWarnings("static-access")
	public SuccessfulLogin(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	@Override
	@Step("the actor tries to enter the application ")
	public <T extends Actor> void performAs(T actor) {
		// TODO Auto-generated method stub
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_TAB);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyRelease(KeyEvent.VK_TAB);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyPress(KeyEvent.VK_TAB);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyRelease(KeyEvent.VK_TAB);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyPress(KeyEvent.VK_ENTER);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyRelease(KeyEvent.VK_ENTER);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyPress(KeyEvent.VK_TAB);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyRelease(KeyEvent.VK_TAB);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyPress(KeyEvent.VK_ENTER);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));
			robot.keyRelease(KeyEvent.VK_ENTER);
			actor.attemptsTo(WaitToLoad.theMiliSeconds(100));

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/test/resources/users.properties"));
			actor.attemptsTo(
					Enter.theValue(prop.getProperty("user")).into(PolicyIssuanceParserUserInterface.INPUT_USER),
					Enter.theValue(prop.getProperty("password")).into(PolicyIssuanceParserUserInterface.INPUT_PASSWORD),
					Click.on(PolicyIssuanceParserUserInterface.BUTTON_SUBMIT_LOGIN), WaitToLoad.theMiliSeconds(3000));

			if (Driver.inTheStage()
					.findElement(By.xpath("//p[contains(text(),'¿Desea cerrar dicha session y crear una nueva?')]"))
					.isDisplayed()) {
				actor.attemptsTo(Click.on(PolicyIssuanceParserUserInterface.BUTTON_MSG_SUBMIT_LOGIN));
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actor.attemptsTo();
	}

	public static SuccessfulLogin withTheUser() {
		return Tasks.instrumented(SuccessfulLogin.class, user, password);
	}

}
