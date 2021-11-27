package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.BonsaiPageUI;

public class BonsaiPage {
	public WebDriver driver;
	BonsaiPageUI b = new BonsaiPageUI();

	public BonsaiPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getReview() {
		return driver.findElement(b.review);
	}

	public WebElement getName() {
		return driver.findElement(b.name);
	}

	public WebElement getEmail() {
		return driver.findElement(b.email);
	}

	public WebElement getTitle() {
		return driver.findElement(b.title);
	}

	public WebElement getBody() {
		return driver.findElement(b.body);
	}

	public WebElement getSubmit() {
		return driver.findElement(b.submit);
	}
}
