package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.RakhiGiftsPage;
import com.mindtree.pageobjects.RakhiPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Rakhi {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(NewProduct.class.getName());

	@Given("^that browser would start$")
	public void that_browser_would_start() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 10----------");
		log.info("opening the browser");
	}

	@And("^it would navigate to \"([^\"]*)\"$")
	public void it_would_navigate_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigates to the site");
	}

	@And("^clicks on rakhi gifts link and goes to rakhi gifts page$")
	public void clicks_on_rakhi_gifts_link_and_goes_to_rakhi_gifts_page() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.getRakhi().click();
		log.info("clicked on rakhi link ");
	}

	@When("^it selects the bhaiya ciao rakhi in rakhi gifts results it goes to that page$")
	public void it_selects_the_bhaiya_ciao_rakhi_in_rakhi_gifts_results_it_goes_to_that_page() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// driver.switchTo( ).alert( ).dismiss();
		er = new ExtentReportsClass(driver);
		er.start("At Rakhi Gifts Results Page");
		RakhiGiftsPage r = new RakhiGiftsPage(driver);
		r.getRakhigifts().click();
		log.info("clicked on Bhaiya Ciao Rakhi");

	}

	@Then("^it should add some given add ons to cart along with rakhi$")
	public void it_should_add_some_given_add_ons_to_cart_along_with_rakhi() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		RakhiPage r = new RakhiPage(driver);
		er.start("At Bhaiya Ciao Rakhi Page");
		int n = r.getAddons().size();
		for (int i = 0; i < n; i++) {
			r.getAddons().get(i).click();
		}
		// wait.until(ExpectedConditions.visibilityOf(c.getGift()));
		r.getCart().click();
		er.end();
		driver.quit();
	}
}
