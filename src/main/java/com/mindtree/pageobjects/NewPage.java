package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.NewPageUI;

public class NewPage {
	public WebDriver driver;
	NewPageUI n = new NewPageUI();

	public NewPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCurtain() {
		return driver.findElement(n.curtain);
	}

}
