package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.mindtree.pageobjects.BonsaiPage;
import com.mindtree.pageobjects.DecorPage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Review {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(Jewellery.class.getName());

	@Given("^browser will be started$")
	public void browser_will_be_started() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 11----------");
		log.info("opening the browser");
	}

	@And("^navigated to \"([^\"]*)\"$")
	public void navigating_to_the(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}

	@When("^hovers on home and lifestyle then selects home decor to navigate to it$")
	public void hovers_on_home_and_lifestyle_then_selects_home_decor_to_navigate_to_it() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(home.getLifeStyle()).build().perform();
		a.moveToElement(home.getDecor()).click().build().perform();
		log.info("clicked on home decor category");
	}

	@Then("^it clicks on bonsai led lights and gets information$")
	public void it_clicks_on_bonsai_led_lights_and_gets_information() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		er = new ExtentReportsClass(driver);
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Home Decor Page");
		// wait.until(ExpectedConditions.alertIsPresent());
		// driver.switchTo( ).alert( ).dismiss();
		DecorPage d = new DecorPage(driver);
		d.getBonsai().click();
		log.info("clicked on bonsai led lights");

	}

	@And("^writes a review about the product by giving \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void writes_a_review_about_the_product_by_giving(String arg1, String arg2, String arg3, String arg4)
			throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		BonsaiPage b = new BonsaiPage(driver);
		er.start("At Bonsai led lights Page");
		b.getReview().click();
		b.getName().sendKeys(arg1);
		b.getEmail().sendKeys(arg2);
		b.getTitle().sendKeys(arg3);
		b.getBody().sendKeys(arg4);
		b.getSubmit().click();
		log.info("review of the product is written");
		er.end();
		driver.quit();
	}
}
