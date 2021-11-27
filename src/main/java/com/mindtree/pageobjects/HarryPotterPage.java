package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.HarryPotterPageUI;

public class HarryPotterPage {
	public WebDriver driver;
	HarryPotterPageUI hp = new HarryPotterPageUI();

	public HarryPotterPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCart() {
		return driver.findElement(hp.cart);
	}

	public WebElement getNote() {
		return driver.findElement(hp.giftnote);
	}

	public WebElement getFrom() {
		return driver.findElement(hp.from);
	}

	public WebElement getTo() {
		return driver.findElement(hp.to);
	}

	public WebElement getCard() {
		return driver.findElement(hp.card);
	}

	public WebElement getShopping() {
		return driver.findElement(hp.shopping);
	}

}
