package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.LondonPageUI;

public class LondonPage {
	public WebDriver driver;
	LondonPageUI l = new LondonPageUI();

	public LondonPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMap() {
		return driver.findElement(l.map);
	}
}
