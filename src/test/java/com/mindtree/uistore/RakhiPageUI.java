package com.mindtree.uistore;

import org.openqa.selenium.By;

public class RakhiPageUI {
	public By addons = By.cssSelector("img[onclick='SPICEADDONS.Imagecheck(this)']");
	public By cart = By.xpath("(//button[@type='submit'])[2]");
}
