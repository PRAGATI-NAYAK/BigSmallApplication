package com.mindtree.uistore;

import org.openqa.selenium.By;

public class CheckOutPageUI {
	public By email = By.xpath("//input[@placeholder='Email']");
	public By firstname = By.xpath("//input[@placeholder='First name']");
	public By lastname = By.xpath("//input[@placeholder='Last name']");

	public By address = By.xpath("//input[@placeholder='Address']");
	public By landmark = By.xpath("//input[@placeholder='Landmark*']");

	public By city = By.xpath("//input[@placeholder='City']");
	public By KA = By.xpath("//option[@value='KA']");
	public By state = By.xpath("//select[@placeholder='State']");
	public By pin = By.xpath("//input[@placeholder='PIN code']");
	public By phone = By.xpath("//input[@placeholder='Phone']");
	public By ship = By.xpath("//button[@id='continue_button']");
}
