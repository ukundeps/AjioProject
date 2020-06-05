package com.ajio.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import com.ajio.keyword.Keyword;

public class HomepagePage extends Keyword {
	
	
	@CacheLookup
	@FindBy(css = "a[href=\"/shop/women\"]")
	private static WebElement shopWomen;

	@CacheLookup
	@FindBy(css = "a[href=\"/shop/men\"]")
	private static WebElement shopMen;

	@CacheLookup
	@FindBy(css = "a[href=\"/shop/kids\"]")
	private static WebElement shopKids;

	@CacheLookup
	@FindBy(css = "a[href=\"/shop/sale\"]")
	private static WebElement shopSale;

	@CacheLookup
	@FindBy(css = "span[class=\"login-form login-modal\"]")
	private static WebElement signIn_JoinAjio;

	@CacheLookup
	@FindBy(css = "div[class=\"modal-login-container\"]")
	private static WebElement signUpModalPopUp;

	@CacheLookup
	@FindBy(css = "a[href=\"/selfcare\"]")
	private static WebElement customerCare;

	// methods

	public boolean isShopWomenLinkVisible() {
		return shopWomen.isDisplayed();

	}

	public static void clickShopWomen() {
		shopWomen.click();
	}

	public static boolean isShopMenLinkVisible() {
		return shopMen.isDisplayed();

	}

	public static void clickShopMen() {
		shopMen.click();
	}

	public static boolean isShopKidsLinkVisible() {
		return shopKids.isDisplayed();

	}

	public static void clickShopKids() {
		shopKids.click();
	}

	public static boolean isShopSaleLinkVisible() {
		return shopSale.isDisplayed();

	}

	public static void clickShopSale() {
		shopSale.click();
	}

	public boolean isSignIn_JoinAjioLinkVisible() {
		return signIn_JoinAjio.isDisplayed();

	}

	public static void clickSignIn_JoinAjio() {
		signIn_JoinAjio.click();
	}

	public boolean isCustomerCareLinkVisible() {
		return customerCare.isDisplayed();

	}

	public static void clickCustomerCare() {
		customerCare.click();
	}

	public boolean isSignUpModalPopUpVisible() {
		return signUpModalPopUp.isDisplayed();

	}
}
