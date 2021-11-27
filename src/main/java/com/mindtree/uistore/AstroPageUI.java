package com.mindtree.uistore;

import org.openqa.selenium.By;

public class AstroPageUI {
	public By reviews = By.cssSelector("span[class='jdgm-prev-badge__text']");
	public By firstReview = By.cssSelector("b[class='jdgm-rev__title']");
	public By wishlist = By.xpath("//button[@aria-label='Add to Wishlist']");
}
