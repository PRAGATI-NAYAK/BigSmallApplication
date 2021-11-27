package com.mindtree.utility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	WebDriver driver;
	public ExtentTest logger;
	public ExtentReports extent;

	public ExtentReportsClass(WebDriver driver) throws IOException {

		ReadPropertyFile read = new ReadPropertyFile();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		extent = new ExtentReports(System.getProperty("user.dir") + read.getExtentReportPath()
				+ TakeScreenShots.getCurrentDateTime() + ".html");
	}

	public void start(String name) throws IOException {

		logger = extent.startTest(name);
		logger.log(LogStatus.PASS,
				logger.addScreenCapture(TakeScreenShots.captureScreenshot(driver)) + "Test Passed " + name);

	}

	public void end() {
		extent.endTest(logger);
		extent.flush();
	}
}
