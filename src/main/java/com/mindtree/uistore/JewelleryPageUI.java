package com.mindtree.uistore;

import org.openqa.selenium.By;

public class JewelleryPageUI {
	public By exclusive = By.xpath("//div[@class='info-sales']//img//parent::div[@class='info-sales']//parent::div[@class='grid-product__content']//a//div[2]//div[@class='grid-product__title']");
	public By soldout = By.xpath("//div[@class='badge badge--sold-out']//parent::div//a//div[2]//div[@class='grid-product__title']");
}
