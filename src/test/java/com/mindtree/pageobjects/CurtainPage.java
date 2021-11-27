package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.CurtainPageUI;

public class CurtainPage {
	public WebDriver driver;
	CurtainPageUI c = new CurtainPageUI();

	public CurtainPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getImage() {
		return driver.findElement(c.image);
	}

	public WebElement getCost() {
		return driver.findElement(c.cost);
	}

	public WebElement getCart() {
		return driver.findElement(c.addtocart);
	}

	public WebElement getGift() {
		return driver.findElement(c.gift);
	}

	public WebElement getCheckOut() {
		return driver.findElement(c.checkout);
	}

	public WebElement getClose() {
		return driver.findElement(c.close);
	}
}