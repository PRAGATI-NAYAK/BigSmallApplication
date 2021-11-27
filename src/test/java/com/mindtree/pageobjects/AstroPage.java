package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.AstroPageUI;

public class AstroPage {
	public WebDriver driver;
	AstroPageUI a = new AstroPageUI();

	public AstroPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getreviews() {
		return driver.findElement(a.reviews);
	}

	public WebElement getFirstReview() {
		return driver.findElement(a.firstReview);
	}

	public WebElement getWishList() {
		return driver.findElement(a.wishlist);
	}
}
