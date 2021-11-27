package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.HomePageUI;

public class HomePage {
	public WebDriver driver;
	HomePageUI home = new HomePageUI();

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getNew() {
		return driver.findElement(home.whatsnew);
	}
	public WebElement getAccount() {
		return driver.findElement(home.myaccount);
	}

	public WebElement getPins() {
		return driver.findElement(home.pins);
	}

	public WebElement getSignIn() {
		return driver.findElement(home.signin);
	}

	public WebElement getRakhi() {
		return driver.findElement(home.rakhi);
	}

	public WebElement getCorporate() {
		return driver.findElement(home.corporate);
	}

	public WebElement getBirthday() {
		return driver.findElement(home.birthdaygifts);
	}

	public WebElement getKids() {
		return driver.findElement(home.kids);
	}

	public WebElement getCategory() {
		return driver.findElement(home.category);
	}

	public WebElement getOfficialMerch() {
		return driver.findElement(home.officialmerch);
	}

	public WebElement getLondon() {
		return driver.findElement(home.london);
	}

	public WebElement getJewellery() {
		return driver.findElement(home.jewellery);
	}

	public WebElement getGiftCard() {
		return driver.findElement(home.giftcard);
	}

	public WebElement getSearch() {
		return driver.findElement(home.search);
	}

	public WebElement getLifeStyle() {
		return driver.findElement(home.lifestyle);
	}

	public WebElement getDecor() {
		return driver.findElement(home.decor);
	}
}
