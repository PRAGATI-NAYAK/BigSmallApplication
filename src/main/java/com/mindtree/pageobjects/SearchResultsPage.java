package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.uistore.SearchResultsPageUI;

public class SearchResultsPage {
	public WebDriver driver;
	SearchResultsPageUI s = new SearchResultsPageUI();

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getbts() {
		return driver.findElement(s.bts);
	}
}
