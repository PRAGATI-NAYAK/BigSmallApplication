package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.LoginPageUI;

public class LoginPage {
	public WebDriver driver;
	LoginPageUI login = new LoginPageUI();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getemail() {
		return driver.findElement(login.email);
	}
	public WebElement getpassword() {
		return driver.findElement(login.password);
	}
	public WebElement getsignin() {
		return driver.findElement(login.signin);
	}
	public WebElement getcreate() {
		return driver.findElement(login.create);
	}
}
