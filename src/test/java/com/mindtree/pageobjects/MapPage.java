package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.MapPageUI;

public class MapPage {
	public WebDriver driver;
	MapPageUI m = new MapPageUI();

	public MapPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getOldPrice() {
		return driver.findElement(m.oldprice);
	}

	public WebElement getNewPrice() {
		return driver.findElement(m.newprice);
	}

	public WebElement getDifference() {
		return driver.findElement(m.difference);
	}

}
