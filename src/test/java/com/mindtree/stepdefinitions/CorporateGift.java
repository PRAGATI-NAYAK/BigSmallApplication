package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mindtree.pageobjects.AstroPage;
import com.mindtree.pageobjects.CorporatePage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CorporateGift {
	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(CorporateGift.class.getName());

	@Given("^starting browser$")
	public void starting_browser() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 2----------");
		log.info("opening the browser");
	}

	@And("^navigating to \"([^\"]*)\"$")
	public void navigating_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}

	@And("^clicks on corporate gifts it navigates to corporate page$")
	public void clicks_on_corporate_gifts_it_navigates_to_corporate_page() throws Throwable {

		HomePage home = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		home.getCorporate().click();
		log.info("clicked on corporate gifts");
	}

	@When("^clicks on Astro Stationery And Phone Holder it displays the information about it$")
	public void clicks_on_Astro_Stationery_And_Phone_Holder_it_displays_the_information_about_it() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		CorporatePage c = new CorporatePage(driver);
		er = new ExtentReportsClass(driver);
		er.start("At Corporates Gifts Page");
		c.getastro().click();
		log.info("clicked on astro stationery and phone holder");

	}

	@Then("^it should check the reviews and add to wishlist$")
	public void it_should_check_the_reviews_and_add_to_wishlist() throws Throwable {
		AstroPage a = new AstroPage(driver);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Astro Stationery And Phone Holder Page");
		a.getreviews().click();
		log.info("First review of the product:" + a.getFirstReview().getText());
		WebElement wishlist = a.getWishList();
		// wait.until(ExpectedConditions.alertIsPresent());
		// driver.switchTo( ).alert( ).dismiss();
		log.info(wishlist.getText());
		wait.until(ExpectedConditions.elementToBeClickable(wishlist));
		wishlist.click();
		log.info("added product to wishlist");
		er.end();
		driver.quit();
	}

}
