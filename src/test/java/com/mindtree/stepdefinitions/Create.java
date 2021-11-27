package com.mindtree.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.pageobjects.CreatePage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.LoginPage;
import com.mindtree.pageobjects.MyAccountPage;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Create { 

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(London.class.getName());

	@Given("^start the browser$")
	public void browser_starts_again() throws Throwable {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("----------Test Case 3----------");
		log.info("opening the browser");
	}

	@And("^navigate to website \"([^\"]*)\"$")
	public void navigate_to_website(String arg1) throws Throwable {

		driver.get(arg1);
		log.info("navigated to the site");
	}
	@And("^clicks on sign in on home page navigates to the page clicks on create account$")
	public void clicks_on_sign_in_on_home_page_navigates_to_the_page_clicks_on_create_account() throws IOException {
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		er = new ExtentReportsClass(driver);
		HomePage home = new HomePage(driver);
		home.getSignIn().click();
		LoginPage login = new LoginPage(driver);
		er.start("At Login Page");
		
		login.getcreate().click();
		log.info("clicked on create account");
		
		
		
	}

    @When("^it navigates to create account it should give \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
public void it_navigates_to_create_account_it_should_give_and(String first,String last,String email,String password) throws IOException {
    	CreatePage c = new CreatePage(driver);
    	er.start("At Create Account Page");
    	c.getFirst().sendKeys(first);
		c.getLast().sendKeys(last);
		c.getEmail().sendKeys(email);
		c.getPassword().sendKeys(password);
         log.info("entered firstname,lastname,email and password");		
		
}

@Then("^it should click on create account and logged in$")
public void it_should_click_on_create_account_and_logged_in() throws IOException {
	HomePage home = new HomePage(driver);
	CreatePage c = new CreatePage(driver);
	c.getCreate().click();
	log.info("clicked on create button");
	String account = home.getAccount().getText();
	if (account.equalsIgnoreCase("my account"))
		log.info("logged in");
	er.start("At Home Page after log in");
}

@And("^when clicked on my account it should go to that page and click on log out$")
public void when_clicked_on_my_account_it_should_go_to_that_page_and_click_on_log_out() throws IOException {
	MyAccountPage my = new MyAccountPage(driver);
	HomePage home = new HomePage(driver);
	WebElement myaccount = home.getAccount();
	myaccount.click();
	er.start("At My Account Page");
	log.info("clicked on my account");
	my.getLogout().click();
	String signin = home.getSignIn().getText();
	if (signin.equalsIgnoreCase("sign in"))
		log.info("logged out");
	er.end();
}
}


