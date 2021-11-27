package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.GiftcardPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Giftcard {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(NewProduct.class.getName());

	@Given("^browser has started$")
	public void browser_has_started() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 4----------");
		log.info("opening the browser");
	}

	@And("^it navigates to \"([^\"]*)\"$")
	public void it_navigates_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigates to the site");
	}

	@When("^clicks on gift card icon and navigates to gift card page$")
	public void clicks_on_gift_card_icon_and_navigates_to_gift_card_page() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		er = new ExtentReportsClass(driver);
		er.start("At Home Page");
		HomePage home = new HomePage(driver);
		home.getGiftCard().click();
		log.info("clicked on gift card icon");
	}

	@Then("^it adds four gift card worth 10k and adds it to cart$")
	public void it_adds_four_gift_card_worth_10k_and_adds_it_to_cart() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		GiftcardPage y = new GiftcardPage(driver);
		er.start("At Gift Card Page of the website");
		y.getTen().click();
		int i = 1;
		while (i < 4) {
			y.getAdd().click();
			i++;
		}
		y.getCart().click();
		WebElement price = y.getMoney();
		wait.until(ExpectedConditions.visibilityOf(price));
		log.info("The gift card sent is worth:" + price.getText());
		er.end();
		driver.quit();
	}
}
