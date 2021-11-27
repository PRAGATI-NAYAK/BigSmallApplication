package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HarryPotterPageUI {
	public By cart = By.xpath("(//button[@type='submit'])[2]");
	public By giftnote = By.cssSelector("input[id='cart-notes']");
	public By from = By.cssSelector("input[id='from']");
	public By to = By.cssSelector("input[id='to']");
	public By card = By.cssSelector("input[id='gift-card']");
	public By shopping = By.cssSelector("a[href='javascript:void(0);']");
}
