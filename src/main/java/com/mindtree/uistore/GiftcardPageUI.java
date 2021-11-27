package com.mindtree.uistore;

import org.openqa.selenium.By;

public class GiftcardPageUI {
	public By tenk = By.cssSelector("div[data-value='Rs. 10000']");
	public By add = By.cssSelector("span[class='js--qty-adjuster js--add']");
	public By cart = By.cssSelector("button[class='btn btn--full add-to-cart spice-submit-button']");
	public By money = By.xpath("(//span[@class='money'])[19]");
}
