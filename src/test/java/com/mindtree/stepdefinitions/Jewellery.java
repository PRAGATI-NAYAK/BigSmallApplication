package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.JewelleryPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Jewellery {
	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(Jewellery.class.getName());

	@Given("^starting the browser$")
	public void starting_the_browser() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 5----------");
		log.info("opening the browser");
	}

	@And("^navigating to the \"([^\"]*)\"$")
	public void navigating_to_the(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}

	@When("^hovers on shop by category and goes to and clicks on it navigates to jewellery page$")
	public void hovers_on_shop_by_category_and_goes_to_and_clicks_on_it_navigates_to_jewellery_page() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(home.getCategory()).build().perform();
		a.moveToElement(home.getJewellery()).click().build().perform();
		log.info("clicked on jewellery category");
	}

	@Then("^it finds exclusive products it should display the title of it$")
	public void it_finds_exclusive_products_it_should_display_the_title_of_it() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		er = new ExtentReportsClass(driver);
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Jewellery Page");
		// wait.until(ExpectedConditions.alertIsPresent());
		// driver.switchTo( ).alert( ).dismiss();
		JewelleryPage j = new JewelleryPage(driver);
		int n = j.getSoldout().size();
		int m = j.getexclusive().size();
		log.info("There are " + n + " products in this page which are sold out");
		for (int i = 0; i < n; i++) {
			log.info((j.getSoldout().get(i)).getText());
		}
		log.info("There are " + m + " exclusive products in this page");
		for (int i = 0; i < m; i++) {
			log.info((j.getexclusive().get(i)).getText());
		}
		er.end();
		driver.quit();
	}

}
