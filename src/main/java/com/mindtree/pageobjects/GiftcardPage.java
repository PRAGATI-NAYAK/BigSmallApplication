package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.GiftcardPageUI;

public class GiftcardPage {
	public WebDriver driver;
	GiftcardPageUI y = new GiftcardPageUI();

	public GiftcardPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTen() {
		return driver.findElement(y.tenk);
	}

	public WebElement getAdd() {
		return driver.findElement(y.add);
	}

	public WebElement getCart() {
		return driver.findElement(y.cart);
	}

	public WebElement getMoney() {
		return driver.findElement(y.money);
	}
}
