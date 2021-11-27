package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.MinionpinPage;
import com.mindtree.pageobjects.HarrypinPage;
import com.mindtree.pageobjects.PinsPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Pins {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(NewProduct.class.getName());

	@Given("^that browser will start$")
	public void that_browser_will_start() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 9----------");
		log.info("opening the browser");
	}

	@And("^it will navigate to \"([^\"]*)\"$")
	public void it_will_navigate_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigates to the site");
	}

	@And("^hovers on shop by category and clicks on lapel pins and brooches and navigates to that page$")
	public void hovers_on_shop_by_category_and_clicks_on_lapel_pins_and_brooches_navigates_to_that_page()
			throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		WebElement category = home.getCategory();
		WebElement pins = home.getPins();
		a.moveToElement(category).build().perform();
		a.moveToElement(pins).click().build().perform();
		log.info("clicked on lapel pins and brooches ");
	}

	@When("^it selects the harry potter pins navigates to the page and adds pin to cart$")
	public void it_selects_the_harry_potter_pins_navigates_to_the_page_and_adds_pin_to_cart() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// driver.switchTo( ).alert( ).dismiss();
		er = new ExtentReportsClass(driver);
		HarrypinPage hp = new HarrypinPage(driver);
		er.start("At Lapel pins and BroochesPage");
		PinsPage p = new PinsPage(driver);
		p.getHarry().click();
		log.info("clicked on Harry Potter Characters Metallic Pins");
		er.start("At Harry Potter Characters Metallic Pins Page");
		hp.getCart().click();
		hp.getShopping().click();
		log.info("added harry pin to cart");

	}

	@Then("^it will come back to pins page selects minions pins and adds it to cart$")
	public void it_will_come_back_to_pins_page_selects_minions_pins_and_adds_it_to_cart() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		HarrypinPage hp = new HarrypinPage(driver);
		MinionpinPage m = new MinionpinPage(driver);
		PinsPage p = new PinsPage(driver);
		Actions a = new Actions(driver);
		// wait.until(ExpectedConditions.visibilityOf(c.getGift()));
		WebElement category = hp.getCategory();
		WebElement pins = hp.getPins();
		a.moveToElement(category).build().perform();
		a.moveToElement(pins).click().build().perform();
		wait.until(ExpectedConditions.visibilityOf(p.getMinion()));
		er.start("At Minions Lapel Pin Page");
		m.getCart().click();
		log.info("added minions pin to cart");
		er.end();
		driver.quit();
	}
}
