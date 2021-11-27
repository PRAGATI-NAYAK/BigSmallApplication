package com.mindtree.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.JewelleryPageUI;

public class JewelleryPage {
	public WebDriver driver;
	JewelleryPageUI j = new JewelleryPageUI();

	public JewelleryPage(WebDriver driver) {
		this.driver = driver;
	}

	public List<WebElement> getexclusive() {
		return driver.findElements(j.exclusive);
	}

	public List<WebElement> getSoldout() {
		return driver.findElements(j.soldout);
	}

}
