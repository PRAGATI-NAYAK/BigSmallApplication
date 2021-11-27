package com.mindtree.uistore;

import org.openqa.selenium.By;

public class HomePageUI {
	public By whatsnew = By.xpath("//button[contains(text(),'New')]");
	public By corporate = By.cssSelector("a[data-dropdown-rel='corporate-gifts']");
	public By category = By.cssSelector("a[data-dropdown-rel='shop-by-category']");
	public By jewellery = By.xpath("(//a[@href='/collections/jewellery'])[3]");
	public By giftcard = By.cssSelector("a[class='site-nav__link site-nav__link--icon giftcardlink']");
	public By search = By.cssSelector("input[placeholder='Search the awesome...']");
	public By officialmerch = By.cssSelector("a[data-dropdown-rel='official-merchandise']");
	public By london = By.xpath("(//a[@href='/collections/luckies-of-london'])[2]");
	public By birthdaygifts = By.xpath("(//a[@href='/collections/birthday-gifts'])[5]");
	public By kids = By.xpath("(//a[@href='/collections/birthday-gifts-for-kids'])[2]");
	public By rakhi = By.cssSelector("a[href='/collections/rakhi-gifts']");
	public By lifestyle = By.xpath("(//a[@href='/collections/home-and-lifestyle-gifts'])[2]");
	public By decor = By.xpath("(//a[@href='/collections/home-decor'])[2]");
	public By pins = By.xpath("(//a[@href='/collections/lapel-pins-brooches'])[2]");
    public By signin=By.xpath("//a[@href='/account/login']//span[@class='link_text']");
    public By myaccount=By.xpath("//a[@href='/account/']//span[@class='link_text']");
}
