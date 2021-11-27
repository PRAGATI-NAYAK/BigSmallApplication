package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.mindtree.uistore.CheckOutPageUI;

public class CheckOutPage {
	public WebDriver driver;
	CheckOutPageUI c = new CheckOutPageUI();

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getAddress() {
		return driver.findElement(c.address);
	}

	public WebElement getKA() {
		return driver.findElement(c.KA);
	}

	public WebElement getEmail() {
		return driver.findElement(c.email);
	}

	public WebElement getFirst() {
		return driver.findElement(c.firstname);
	}

	public WebElement getLast() {
		return driver.findElement(c.lastname);
	}

	public WebElement getLandmark() {
		return driver.findElement(c.landmark);
	}

	public WebElement getCity() {
		return driver.findElement(c.city);
	}

	public WebElement getPin() {
		return driver.findElement(c.pin);
	}

	public WebElement getPhone() {
		return driver.findElement(c.phone);
	}

	public WebElement getShip() {
		return driver.findElement(c.ship);
	}

	public WebElement getState() {
		return driver.findElement(c.state);
	}

}
