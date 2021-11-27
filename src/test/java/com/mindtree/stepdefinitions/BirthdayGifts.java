package com.mindtree.stepdefinitions;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.mindtree.pageobjects.BirthdayGiftsPage;
import com.mindtree.pageobjects.HarryPotterPage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BirthdayGifts {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(Jewellery.class.getName());

	@Given("^browser would start$")
	public void browser_would_start() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 1----------");
		log.info("opening the browser");
	}

	@And("^would navigate to \"([^\"]*)\"$")
	public void would_navigate_to(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}

	@And("^hovers on birthday gifts and clicks on option birthday gift for kids navigates to that page$")
	public void hovers_on_birthday_gifts_and_clicks_on_option_birthday_gift_for_kids_navigates_to_that_page()
			throws Throwable {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		WebElement gift = home.getBirthday();
		WebElement kid = home.getKids();
		a.moveToElement(gift).build().perform();
		a.moveToElement(kid).click().build().perform();
		log.info("clicked on birthday gifts for kids option");
		er = new ExtentReportsClass(driver);
		er.start("At Birthday gifts for kids Page");
	}

	@When("^selects the sort by feature as best selling and should select harry potter$")
	public void selects_the_sort_by_feature_as_best_selling_and_should_select_harry_potter() {

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		BirthdayGiftsPage bg = new BirthdayGiftsPage(driver);
		WebElement sort = bg.getSort();
		sort.click();
		int i = 1;
		while (i < 3) {
			sort.sendKeys(Keys.DOWN);
			i++;
		}
		sort.sendKeys(Keys.ENTER);
		bg.getHarry().click();
		log.info("clicked on the harry potter");
	}

	@Then("^it should add to cart with a gift note with \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void it_should_add_to_cart_with_a_gift_note_with_from_to_and_note(String arg1, String arg2, String arg3)
			throws Throwable {

		HarryPotterPage hp = new HarryPotterPage(driver);
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Harry Potter Page");
		hp.getCart().click();
		log.info("adding to cart");
		// wait.until(ExpectedConditions.alertIsPresent());
		hp.getNote().click();
		hp.getFrom().sendKeys(arg1);
		hp.getTo().sendKeys(arg2);
		hp.getCard().sendKeys(arg3);
		log.info("adding a gift note");
		hp.getShopping().click();
		// driver.switchTo( ).alert( ).dismiss();
		er.end();
		driver.quit();
	}

}