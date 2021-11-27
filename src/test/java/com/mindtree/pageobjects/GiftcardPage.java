package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.GiftcardPageUI;

public class GiftcardPage {
	public WebDriver driver;
	GiftcardPageUI g = new GiftcardPageUI();

	public GiftcardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTen() {
		return driver.findElement(g.tenk);
	}

	public WebElement getAdd() {
		return driver.findElement(g.add);
	}

	public WebElement getCart() {
		return driver.findElement(g.cart);
	}

	public WebElement getMoney() {
		return driver.findElement(g.money);
	}
}
