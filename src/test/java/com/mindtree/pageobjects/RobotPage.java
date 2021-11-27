package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.RobotPageUI;


public class RobotPage {
	public WebDriver driver;
	RobotPageUI r = new RobotPageUI();

	public RobotPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRobot() {
		return driver.findElement(r.robot);
	}
	public WebElement getSubmit() {
		return driver.findElement(r.submit);
	}
}
