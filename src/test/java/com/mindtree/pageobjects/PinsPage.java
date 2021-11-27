package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.PinsPageUI;

public class PinsPage {
	public WebDriver driver;
	PinsPageUI p = new PinsPageUI();

	public PinsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHarry() {
		return driver.findElement(p.harry);
	}

	public WebElement getMinion() {
		return driver.findElement(p.minion);
	}
}
