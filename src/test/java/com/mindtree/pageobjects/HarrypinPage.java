package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.HarrypinPageUI;

public class HarrypinPage {
	public WebDriver driver;
	HarrypinPageUI hp = new HarrypinPageUI();

	public HarrypinPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCart() {
		return driver.findElement(hp.cart);
	}

	public WebElement getShopping() {
		return driver.findElement(hp.shopping);
	}

	public WebElement getCategory() {
		return driver.findElement(hp.category);
	}

	public WebElement getPins() {
		return driver.findElement(hp.pins);
	}

}
