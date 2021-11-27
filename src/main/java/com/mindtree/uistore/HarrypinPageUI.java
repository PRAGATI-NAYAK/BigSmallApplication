package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HarrypinPageUI {
	public By cart = By.xpath("(//button[@type='submit'])[2]");
	public By shopping = By.cssSelector("a[href='javascript:void(0);']");
	public By category = By.cssSelector("a[data-dropdown-rel='shop-by-category']");
	public By pins = By.xpath("(//a[@href='/collections/lapel-pins-brooches'])[2]");
	public By close = By.xpath("div[class='wa-callout-card-close-btn wa-callout-card-close-btn-right']");
}
