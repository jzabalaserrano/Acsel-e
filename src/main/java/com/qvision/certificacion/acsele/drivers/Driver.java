package com.qvision.certificacion.acsele.drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Driver {
	static WebDriver driver;

	public Driver() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\drivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static Driver web() {
		return new Driver();
	}

	public static WebDriver inThePage(String url) {
		driver.get(url);
		return driver;
	}

	public static WebDriver inTheStage() {
		return driver;
	}
}