package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.CreatePageUI;

public class CreatePage {
	public WebDriver driver;
	CreatePageUI c = new CreatePageUI();

	public CreatePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFirst() {
		return driver.findElement(c.first);
	}
	public WebElement getLast() {
		return driver.findElement(c.last);
	}
	public WebElement getEmail() {
		return driver.findElement(c.email);
	}
	public WebElement getPassword() {
		return driver.findElement(c.password);
	}
	public WebElement getCreate() {
		return driver.findElement(c.create);
	}
	
}
