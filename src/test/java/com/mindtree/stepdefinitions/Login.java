package com.mindtree.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.LoginPage;
//import com.mindtree.pageobjects.RobotPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login { 
	
	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(London.class.getName());

	@Given("^browser start$")
	public void browser_start() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 6----------");
		log.info("opening the browser");
	}

	@And("^navigate to the\"([^\"]*)\"$")
	public void navigate_to_the(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}
	@And("^clicks on sign in on home page$")
	public void clicks_on_sign_in_on_home_page() throws IOException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		HomePage home = new HomePage(driver);
		home.getSignIn().click();
		log.info("clicked on sign in");
		er = new ExtentReportsClass(driver);
		er.start("At Login Page");
	}
	@When("^navigates to that page enter \"([^\"]*)\" and \"([^\"]*)\"$")
    public void navigates_to_that_page_enter_and(String email,String password) {
		LoginPage login = new LoginPage(driver);
		login.getemail().sendKeys(email);
		login.getpassword().sendKeys(password);
		log.info("entered email and password");
		
	}
	@Then("^it should click on login$")
	public void it_should_click_on_login() throws IOException {
		LoginPage login = new LoginPage(driver);
		login.getsignin().click();
		er.start("At Robot Page");
		log.info("clicked on sign in button");
//		RobotPage r = new RobotPage(driver);
//		r.getRobot().click();
//		r.getSubmit().click();	
			er.end();
	}

}

