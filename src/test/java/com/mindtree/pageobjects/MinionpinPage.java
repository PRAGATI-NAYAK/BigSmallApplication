package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.MinionpinPageUI;

public class MinionpinPage {

	public WebDriver driver;
	MinionpinPageUI m = new MinionpinPageUI();

	public MinionpinPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCart() {
		return driver.findElement(m.cart);
	}
}
