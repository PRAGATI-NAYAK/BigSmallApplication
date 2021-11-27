package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.BTSPageUI;

public class BTSPage {
	public WebDriver driver;
	BTSPageUI bts = new BTSPageUI();

	public BTSPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBase() {
		return driver.findElement(bts.base);
	}

	public WebElement getCode() {
		return driver.findElement(bts.cod);
	}

	public WebElement getCheck() {
		return driver.findElement(bts.check);
	}

	public WebElement getAvailable() {
		return driver.findElement(bts.available);
	}
}
