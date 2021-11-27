package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.LondonPage;
import com.mindtree.pageobjects.MapPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class London {
	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(CorporateGift.class.getName());

	@Given("^browser starts again$")
	public void browser_starts_again() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 7----------");
		log.info("opening the browser");
	}

	@And("^has navigated to \"([^\"]*)\"$")
	public void has_navigated_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}

	@And("^hovers on official merchandise and clicks on luckies of london$")
	public void hovers_on_official_merchandise_and_clicks_on_luckies_of_london() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		WebElement merch = home.getOfficialMerch();
		a.moveToElement(merch).build().perform();
		WebElement london = home.getLondon();
		a.moveToElement(london).click().build().perform();
		log.info("clicked on luckies of london");
	}

	@When("^it navigates to that page it clicks on chalkboard map diy and gets its information$")
	public void it_navigates_to_that_page_it_clicks_on_chalkboard_map_diy_and_gets_its_information() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		er = new ExtentReportsClass(driver);
		er.start("At luckies of london Page");
		LondonPage l = new LondonPage(driver);
		WebElement map = l.getMap();
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		wait.until(ExpectedConditions.visibilityOf(map));
		log.info(map.getText());
		map.click();
		log.info("clicked on chalkboard map diy");

	}

	@Then("^it should check the old price and new price and the difference of them$")
	public void it_should_check_the_old_price_and_new_price_and_the_differernce_of_them() throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 5000);
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Chalkboard map diy Page");
		MapPage m = new MapPage(driver);
		WebElement oldprice = m.getOldPrice();
		WebElement newprice = m.getNewPrice();
		WebElement difference = m.getDifference();
		log.info(oldprice.getText());
		// wait.until(ExpectedConditions.alertIsPresent());
		// driver.switchTo( ).alert( ).dismiss();
		log.info(newprice.getText());
		log.info(difference.getText());
//			wait.until(ExpectedConditions.elementToBeClickable());
		er.end();
		driver.quit();
	}

}