package com.mindtree.uistore;

import org.openqa.selenium.By;

public class MapPageUI {

	public By newprice = By.xpath("//span[@class='price-new']//div[@class='price-field']//span[@class='money']");
	public By oldprice = By.xpath("//span[@class='price-old']//span[@class='money']");
	public By difference = By.xpath("//span[@id='comparePrice']//span[@class='money']");

}
