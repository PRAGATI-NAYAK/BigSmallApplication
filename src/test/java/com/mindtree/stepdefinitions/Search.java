package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mindtree.pageobjects.BTSPage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.SearchResultsPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Search {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(CorporateGift.class.getName());

	@Given("^browser will start$")
	public void browser_will_start() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 12----------");
		log.info("opening the browser");
	}

	@And("^will navigate to \"([^\"]*)\"$")
	public void will_navigate_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}

	@When("^clicks on search box and enters \"([^\"]*)\" and navigates to search results page$")
	public void clicks_on_search_box_and_enters_and_navigates_to_search_results_page(String arg1) throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.getSearch().sendKeys(arg1);
		log.info("clicked on search box and entered bts");
		home.getSearch().sendKeys(Keys.ENTER);
	}

	@Then("^it selects item in results and clicks on it to navigate to that page$")
	public void it_selects_item_in_results_and_clicks_on_it_to_navigate_to_that_page() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		er = new ExtentReportsClass(driver);
		er.start("At Search Results Page");
		SearchResultsPage s = new SearchResultsPage(driver);
		s.getbts().click();
		log.info("clicked on bts");

	}

	@And("^it selects particular requirements and checks if cod is available on code \"([^\"]*)\"$")
	public void it_selects_particular_requirements_and_checks_if_cod_is_available_on_code(String arg1)
			throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At BTS Page");
		BTSPage bts = new BTSPage(driver);
		bts.getBase().click();
		log.info("clicked on pink base");
		bts.getCode().sendKeys(arg1);
		log.info("enter postal code");
		bts.getCheck().click();
		WebElement available = bts.getAvailable();
		wait.until(ExpectedConditions.visibilityOf(available));
		log.info(available.getText());
		// driver.switchTo( ).alert( ).dismiss();
		// wait.until(ExpectedConditions.elementToBeClickable());
		er.end();
		driver.quit();
	}

}
