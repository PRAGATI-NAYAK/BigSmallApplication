package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.CorporatePageUI;

public class CorporatePage {
	public WebDriver driver;
	CorporatePageUI c = new CorporatePageUI();

	public CorporatePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getastro() {
		return driver.findElement(c.astro);
	}
}
