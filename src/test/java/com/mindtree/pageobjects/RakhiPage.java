package com.mindtree.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.RakhiPageUI;

public class RakhiPage {
	public WebDriver driver;
	RakhiPageUI r = new RakhiPageUI();

	public RakhiPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCart() {
		return driver.findElement(r.cart);
	}

	public List<WebElement> getAddons() {
		return driver.findElements(r.addons);
	}
}
