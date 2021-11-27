package com.mindtree.testrunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import com.mindtree.pageobjects.AstroPage;
import com.mindtree.pageobjects.BTSPage;
import com.mindtree.pageobjects.BirthdayGiftsPage;
import com.mindtree.pageobjects.BonsaiPage;
import com.mindtree.pageobjects.CheckOutPage;
import com.mindtree.pageobjects.CorporatePage;
import com.mindtree.pageobjects.CreatePage;
import com.mindtree.pageobjects.CurtainPage;
import com.mindtree.pageobjects.DecorPage;
import com.mindtree.pageobjects.HarryPotterPage;
import com.mindtree.pageobjects.HarrypinPage;
import com.mindtree.pageobjects.HomePage;
import com.mindtree.pageobjects.JewelleryPage;
import com.mindtree.pageobjects.LoginPage;
import com.mindtree.pageobjects.LondonPage;
import com.mindtree.pageobjects.MapPage;
import com.mindtree.pageobjects.MinionpinPage;
import com.mindtree.pageobjects.MyAccountPage;
import com.mindtree.pageobjects.NewPage;
import com.mindtree.pageobjects.PinsPage;
import com.mindtree.pageobjects.RakhiGiftsPage;
import com.mindtree.pageobjects.RakhiPage;
import com.mindtree.pageobjects.RobotPage;
import com.mindtree.pageobjects.SearchResultsPage;
import com.mindtree.pageobjects.GiftcardPage;
import com.mindtree.utility.DataDriven;
import com.mindtree.utility.ExtentReportsClass;
import com.mindtree.utility.ReadPropertyFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BigSmallApplication {

	WebDriver driver;
	ExtentReportsClass er;
	protected static Logger log = LogManager.getLogger(BigSmallApplication.class.getName());

	@BeforeMethod
	public void start() throws IOException {

		ReadPropertyFile read = new ReadPropertyFile();
		driver = read.getBrowser();
		log.info("opening the browser");
		driver.get(read.getUrl());
		log.info("navigated to the site");

	}

	
	  @Test(priority = 1) public void testcase1() throws IOException,
	  InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  log.info("----------Test Case 1----------");
	  HomePage home = new HomePage(driver); 
	  Actions a = new Actions(driver); 
	  WebElement gift = home.getBirthday();
	  WebElement kid = home.getKids();
	  a.moveToElement(gift).build().perform();
	  a.moveToElement(kid).click().build().perform();
	  log.info("clicked on birthday gifts for kids option");
	  er=new ExtentReportsClass(driver); 
	  er.start("At Birthday Gifts for kids Page");
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
	  HarryPotterPage hp = new HarryPotterPage(driver);
	  er.start(" At Harry Potter Page"); 
	  hp.getCart().click();
	  log.info("adding to cart"); 
	  hp.getNote().click();
	  hp.getFrom().sendKeys("abcdefg");
	  hp.getTo().sendKeys("kid");
	  hp.getCard().sendKeys("Wish you a very Happy Birthday!!!	");
	  log.info("adding a gift note"); 
	  hp.getShopping().click();
	  er.end();
	  }
	  @Test(priority = 2) public void testcase2() throws IOException,
	  InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  log.info("----------Test Case 2----------"); 
	  HomePage home = new HomePage(driver); 
	  home.getCorporate().click();
	  log.info("clicked on corporate gifts"); 
	  CorporatePage c = new CorporatePage(driver); 
	  er = new ExtentReportsClass(driver);
	  er.start("At Corporates Gifts Page"); 
	  c.getastro().click();
	  log.info("clicked on astro stationery and phone holder"); 
	  AstroPage a = new  AstroPage(driver); 
	 // WebDriverWait wait = new WebDriverWait(driver, 500); 
	  //
	//  wait.until(ExpectedConditions.visibilityOf(preview));
	  er.start(" At Astro Stationery And Phone Holder Page");
	  a.getreviews().click();
	  log.info("First review of the product:" +a.getFirstReview().getText());
	  WebElement wishlist = a.getWishList(); 
	  //wait.until(ExpectedConditions.alertIsPresent()); 
	  // driver.switchTo( ).alert().dismiss(); 
	  log.info(wishlist.getText());
	  //wait.until(ExpectedConditions.elementToBeClickable(wishlist));
	  wishlist.click(); 
	  log.info("added product to wishlist"); 
	  er.end();
	  
	  }

	

	@Test(dataProvider = "getData3", priority = 3)
	public void testcase3(String first, String last, String email, String password)
			throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 3----------");
		HomePage home = new HomePage(driver);
		home.getSignIn().click();
		LoginPage login = new LoginPage(driver);
		MyAccountPage my = new MyAccountPage(driver);
		CreatePage c = new CreatePage(driver);
		login.getcreate().click();
		c.getFirst().sendKeys(first);
		c.getLast().sendKeys(last);
		c.getEmail().sendKeys(email);
		c.getPassword().sendKeys(password);
		c.getCreate().click();
		String account = home.getAccount().getText();
		WebElement myaccount = home.getAccount();
		if (account.equalsIgnoreCase("my account"))
			log.info("logged in");
		myaccount.click();
		my.getLogout().click();
		String signin = home.getSignIn().getText();
		if (signin.equalsIgnoreCase("sign in"))
			log.info("logged out");

	}

	@DataProvider
	public Object[][] getData3() {

		Object[][] data = new Object[1][4];
		data[0][0] = "abc123def45678";
		data[0][1] = "123a76bc456def";
		data[0][2] = "a1b2c0983d4e5f6@gmail.com";
		data[0][3] = "8765432143";

		return data;
	}

	
	@Test(priority = 4)
	public void testcase4() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 4----------");
		er = new ExtentReportsClass(driver);
		er.start("At Home Page");
		HomePage home = new HomePage(driver);
		home.getGiftCard().click();
		log.info("clicked on gift card icon");
		WebDriverWait wait = new WebDriverWait(driver, 500);
		GiftcardPage g = new GiftcardPage(driver);
		er.start("At Gift Card Page of the website");
		WebElement ten = g.getTen();
		wait.until(ExpectedConditions.visibilityOf(ten));
		ten.click();
		int i = 1;
		while (i < 4) {
			g.getAdd().click();
			i++;
		}
		g.getCart().click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebElement price = g.getMoney();
		wait.until(ExpectedConditions.visibilityOf(price));
		log.info("The gift card sent is worth:" + price.getText());
		er.end();
	}

	@Test(priority = 5)
	public void testcase5() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 5----------");
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(home.getCategory()).build().perform();
		a.moveToElement(home.getJewellery()).click().build().perform();
		log.info("clicked on jewellery category"); 
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		er = new ExtentReportsClass(driver); 
		//wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Jewellery Page");
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

	}

	@Test(dataProvider = "getData6", priority = 6)
	public void testcase6(String email, String password) throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 6----------");
		HomePage home = new HomePage(driver);
		home.getSignIn().click();
		LoginPage login = new LoginPage(driver);
		login.getemail().sendKeys(email);
		login.getpassword().sendKeys(password);
		login.getsignin().click();
		RobotPage r = new RobotPage(driver);
		r.getRobot().click();
		r.getSubmit().click();

	}

	@DataProvider
	public Object[][] getData6() {

		Object[][] data = new Object[1][2];
		data[0][0] = "pragatiaravind1999@gmail.com";
		data[0][1] = "pragati@aravind";

		return data;
	}
	
	@Test(priority = 7)
	public void testcase7() throws IOException,
	  InterruptedException { 
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		log.info("----------Test Case 7----------");
		HomePage home= new HomePage(driver); 
		Actions a = new Actions(driver); 
		WebElement merch =home.getOfficialMerch(); 
		a.moveToElement(merch).build().perform();
		WebElement london = home.getLondon(); 
		a.moveToElement(london).click().build().perform();
	  log.info("clicked on luckies of london");
	  er = new ExtentReportsClass(driver); 
	  er.start("At luckies of london Page");
	  LondonPage l = new LondonPage(driver); 
	  WebElement map = l.getMap(); 
	  WebDriverWait wait = new WebDriverWait(driver, 500);
	  wait.until(ExpectedConditions.visibilityOf(map)); log.info(map.getText());
	  map.click(); log.info("clicked on chalkboard map diy"); 
	  // WebDriverWait wait= new WebDriverWait(driver, 5000); 
	  //wait.until(ExpectedConditions.visibilityOf(preview));
	  er.start(" At Chalkboard map diy Page");
	  MapPage m = new MapPage(driver);
	  WebElement oldprice = m.getOldPrice();
	  WebElement newprice = m.getNewPrice();
	  WebElement difference = m.getDifference(); 
	  log.info(oldprice.getText()); 
	  //wait.until(ExpectedConditions.alertIsPresent()); 
	  // driver.switchTo( ).alert().dismiss(); 
	  log.info(newprice.getText()); 
	  log.info(difference.getText()); 
	  //wait.until(ExpectedConditions.elementToBeClickable()); 
	  er.end();
	  
	  }

	@Test(priority = 8)
	public void testcase8() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 8----------");
		HomePage home = new HomePage(driver);
		home.getNew().click();
		er = new ExtentReportsClass(driver);
		er.start("At Whats new Page");
		NewPage n = new NewPage(driver);
		n.getCurtain().click();
		log.info("clicked on Star and Moon Curtain LED Lights");
		CurtainPage c = new CurtainPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 500);
		er.start("At Star and Moon Curtain LED Lights Page");
		c.getImage().click();
		log.info("The price of the product" + c.getCost().getText());
		c.getCart().click();
		log.info("Adding to cart");
		wait.until(ExpectedConditions.visibilityOf(c.getGift()));
		c.getGift().click();
		log.info("packing in a gift wrap");
		c.getCheckOut().click();
		log.info("checking out");
		c.getClose().click();
		CheckOutPage ck = new CheckOutPage(driver);
		DataDriven data = new DataDriven();
		ArrayList<String> arr = data.getData("New Product");
		er.start("At CheckOuts Page");
		ck.getEmail().sendKeys(arr.get(1));
		log.info("added email");
		ck.getFirst().sendKeys(arr.get(2));
		log.info("added first name");
		ck.getLast().sendKeys(arr.get(3));
		log.info("added last name");
		ck.getAddress().sendKeys(arr.get(4));
		log.info("added address");
		ck.getLandmark().sendKeys(arr.get(5));
		log.info("added landmark");
		ck.getCity().sendKeys(arr.get(6));
		log.info("added city");
		ck.getState().click();
		ck.getKA().click();
		ck.getState().sendKeys(Keys.ENTER);
		log.info("added state");
		ck.getPin().sendKeys(arr.get(7));
		log.info("added pin code");
		ck.getPhone().sendKeys(arr.get(8));
		log.info("added contact");
		ck.getShip().click();
		log.info("clicked on continue shipping");
		er.end();
	}

	@Test(priority = 9)
	public void testcase9() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 9----------");
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		WebElement category = home.getCategory();
		WebElement pins = home.getPins();
		a.moveToElement(category).build().perform();
		a.moveToElement(pins).click().build().perform();
		HarrypinPage hp = new HarrypinPage(driver);
		log.info("clicked on lapel pins and brooches ");
		er = new ExtentReportsClass(driver);
		er.start("At Lapel pins and Brooches Page");
		PinsPage p = new PinsPage(driver);
		p.getHarry().click();
		log.info("clicked on Harry Potter Characters Metallic Pins");
		er.start("At Harry Potter Characters Metallic Pins Page");
		hp.getCart().click();
		WebElement shop = hp.getShopping();
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.elementToBeClickable(shop));
		shop.click();
		log.info("added harry pin to cart");
		MinionpinPage m = new MinionpinPage(driver); 
		// // WebElement minion = p.getMinion(); 
		// WebElement	category1 = hp.getCategory(); 
		// WebElement pins1 = hp.getPins(); 
		//a.moveToElement(category1).build().perform();
		//	a.moveToElement(pins1).click().build().perform();
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(p.getMinion()));
		p.getMinion().click();
		er.start("At Minions Lapel Pin Page");
		m.getCart().click();
		log.info("added minions pin to cart");
		er.start("in cart");
		er.end();

	}

	@Test(priority = 10)
	public void testcase10() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 10----------");
		HomePage home = new HomePage(driver);
		home.getRakhi().click();
		log.info("clicked on rakhi link "); // driver.switchTo( ).alert( ).dismiss();
		er = new ExtentReportsClass(driver);
		er.start("At Rakhi Gifts Results Page");
		RakhiGiftsPage r = new RakhiGiftsPage(driver);
		r.getRakhigifts().click();
		log.info("clicked on Bhaiya Ciao Rakhi");
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		RakhiPage rk = new RakhiPage(driver);
		er.start("At Bhaiya Ciao Rakhi Page");
		int n = rk.getAddons().size();
		for (int i = 0; i < n; i++) {
			rk.getAddons().get(i).click();
		} //
		// wait.until(ExpectedConditions.visibilityOf(c.getGift()));
		rk.getCart().click();
		er.end();
	}

	@Test(priority = 11)
	public void testcase11() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 11----------");
		HomePage home = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(home.getLifeStyle()).build().perform();
		a.moveToElement(home.getDecor()).click().build().perform();
		log.info("clicked on home decor category");
		// WebDriverWait wait = new WebDriverWait(driver, 500);
		er = new ExtentReportsClass(driver); //
		// wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At Home Decor Page"); //
		//wait.until(ExpectedConditions.alertIsPresent());
		// driver.switchTo( ).alert().dismiss();
		DecorPage d = new DecorPage(driver);
		d.getBonsai().click();
		log.info("clicked on bonsai led lights");
		BonsaiPage b = new BonsaiPage(driver);
		er.start("At Bonsai led lights Page");
		b.getReview().click();
		b.getName().sendKeys("abcd");
		b.getEmail().sendKeys("abcd@gmail.com");
		b.getTitle().sendKeys("Good Product");
		b.getBody().sendKeys("Very beautiful when kept on top of the table");
		b.getSubmit().click();
		log.info("review of the product is written");
		er.end();

	}

	@Test(priority = 12)
	public void testcase12() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		log.info("----------Test Case 12----------");
		HomePage home = new HomePage(driver);
		home.getSearch().sendKeys("BTS Action Figure - Set of 7");
		log.info("clicked on search box and entered bts");
		home.getSearch().sendKeys(Keys.ENTER);
		er = new ExtentReportsClass(driver);
		er.start("At Search Results Page");
		SearchResultsPage s = new SearchResultsPage(driver);
		s.getbts().click();
		log.info("clicked on bts");
		WebDriverWait wait = new WebDriverWait(driver, 500); //
//	  wait.until(ExpectedConditions.visibilityOf(preview));
		er.start(" At BTS Page");
		BTSPage bts = new BTSPage(driver);
		bts.getBase().click();
		log.info("clicked on pink base");
		bts.getCode().sendKeys("560057");
		log.info("enter postal code");
		bts.getCheck().click();
		WebElement available = bts.getAvailable();
		wait.until(ExpectedConditions.visibilityOf(available));
		log.info(available.getText());
		er.end();

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		driver = null;
	}

}