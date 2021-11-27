package com.mindtree.uistore;

import org.openqa.selenium.By;

public class BonsaiPageUI {
	public By review = By.cssSelector("a[class='jdgm-write-rev-link']");
	public By name = By.cssSelector("input[name='reviewer_name']");
	public By email = By.cssSelector("input[name='reviewer_email']");
	public By title = By.cssSelector("input[name='review_title']");
	public By body = By.cssSelector("textarea[name='review_body']");
	public By submit = By.cssSelector("input[value='Submit Review']");
}
