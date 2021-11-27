package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.DecorPageUI;

public class DecorPage {
	public WebDriver driver;
	DecorPageUI d = new DecorPageUI();

	public DecorPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBonsai() {
		return driver.findElement(d.bonsai);
	}
}
