package com.mindtree.uistore;

import org.openqa.selenium.By;

public class CurtainPageUI {

	public By image = By.xpath(
			"//img[@src='//cdn.shopify.com/s/files/1/1305/2183/products/StarMoonStringCurtainLights3_compact.jpg?v=1636355799']");
	public By cost = By.xpath("(//span[@class='money'])[1]");
	public By addtocart = By.xpath("//button[@class='btn btn--full add-to-cart spice-submit-button']");
	public By gift = By.xpath("//input[@id='gift-wrapping']");
	public By checkout = By.xpath("//span[contains(text(),'Go To Checkout')]");
	public By close = By.xpath("//img[@class='wa-optin-widget-close-img']");
}
