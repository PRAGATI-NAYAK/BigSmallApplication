package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.RakhiGiftsPageUI;

public class RakhiGiftsPage {
	public WebDriver driver;
	RakhiGiftsPageUI r = new RakhiGiftsPageUI();

	public RakhiGiftsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getRakhigifts() {
		return driver.findElement(r.rakhigift);
	}
}
