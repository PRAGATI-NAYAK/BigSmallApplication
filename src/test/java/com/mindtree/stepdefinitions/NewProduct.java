package com.mindtree.stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mindtree.pageobjects.CheckOutPage;
import com.mindtree.pageobjects.CurtainPage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.NewPage;
import com.mindtree.utility.DataDriven;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewProduct {
	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(NewProduct.class.getName());

	@Given("^browser starts$")
	public void browser_starts() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 8----------");
		log.info("opening the browser");
	}

	@And("^navigates to \"([^\"]*)\"$")
	public void navigates_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigates to the site");
	}

	@And("^clicks on whats new it navigates to new page$")
	public void clicks_on_whats_new_it_navigates_to_new_page() throws Throwable {
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.getNew().click();
		log.info("clicked on whats new");
	}

	@When("^clicks on Star and Moon Curtain LED Lights it displays the information about it$")
	public void clicks_on_Star_and_Moon_Curtain_LED_Lights_it_displays_the_information_about_it() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// driver.switchTo( ).alert( ).dismiss();
		er = new ExtentReportsClass(driver);
		er.start("At Whats new Page");
		NewPage n = new NewPage(driver);
		n.getCurtain().click();
		log.info("clicked on Star and Moon Curtain LED Lights");

	}

	@Then("^it should check the price and add to cart with gift wrap$")
	public void it_should_check_the_price_and_add_to_cart_with_gift_wrap() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		CurtainPage c = new CurtainPage(driver);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 500);
		er.start("At Star and Moon Curtain LED Lights Page");
		c.getImage().click();
		log.info("The price of the product" + c.getCost().getText());
		c.getCart().click();
		log.info("Adding to cart");
		wait.until(ExpectedConditions.visibilityOf(c.getGift()));
		c.getGift().click();
		log.info("packing in a gift wrap");
		c.getCheckOut().click();
		log.info("checking out");
		c.getClose().click();
	}

	@And("^give shipping details$")
	public void give_shipping_details() throws IOException {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		CheckOutPage ck = new CheckOutPage(driver);
		DataDriven data = new DataDriven();
		ArrayList<String> arr = data.getData("New Product");
		er.start("At CheckOuts Page");
		ck.getEmail().sendKeys(arr.get(1));
		log.info("added email");
		ck.getFirst().sendKeys(arr.get(2));
		log.info("added first name");
		ck.getLast().sendKeys(arr.get(3));
		log.info("added last name");
		ck.getAddress().sendKeys(arr.get(4));
		log.info("added address");
		ck.getLandmark().sendKeys(arr.get(5));
		log.info("added landmark");
		ck.getCity().sendKeys(arr.get(6));
		log.info("added city");
		ck.getState().click();
		ck.getKA().click();
		ck.getState().sendKeys(Keys.ENTER);
		log.info("added state");
		ck.getPin().sendKeys(arr.get(7));
		log.info("added pin code");
		ck.getPhone().sendKeys(arr.get(8));
		log.info("added contact");
		ck.getShip().click();
		log.info("clicked on continue shipping");
		er.end();
		driver.quit();
	}
}
