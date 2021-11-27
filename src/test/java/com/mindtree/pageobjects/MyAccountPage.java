package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.MyAccountPageUI;

public class MyAccountPage {
	public WebDriver driver;

MyAccountPageUI my = new MyAccountPageUI();

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogout() {
		return driver.findElement(my.logout);
	}
}
