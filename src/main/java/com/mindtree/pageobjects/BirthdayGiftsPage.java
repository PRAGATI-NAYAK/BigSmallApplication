package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.BirthdayGiftsPageUI;

public class BirthdayGiftsPage {
	public WebDriver driver;
	BirthdayGiftsPageUI bg = new BirthdayGiftsPageUI();

	public BirthdayGiftsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSort() {
		return driver.findElement(bg.sort);
	}

	public WebElement getHarry() {
		return driver.findElement(bg.harry);
	}
}
