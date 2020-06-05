package com.ajio.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.keyword.Keyword;
@Listeners(com.ajio.listner.Listener.class)
public class HomePage extends Keyword {

	@BeforeMethod
	public static void setUp() {
		openBrowser("chrome");
		maxiBrowserWindow();
		launchURL("https://www.ajio.com");
		deleteAllCookies();
		pageLoadTimeOut(20, "SECONDS");
		implicitWait(20, "SECONDS");
	}

	@Test(description = "To verify Homepage title is displaying as \"Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO\"")
	public static void ajio_001() {
		Assert.assertEquals(getTitle(), "Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO",
				"Title not matched!!");

	}

	@Test(description = "To verify Page is redirecting to \"Online Shopping for Women – Clothing, Footwear, Fashion & Accessories | AJIO\" Page after clicking on \"SHOP WOMEN\" Link on homepage")
	public static void ajio_002() {
		click("shopWomen");
		expllicitWait(8, "SECONDS");
		Assert.assertEquals(getTitle(), "Online Shopping for Women – Clothing, Footwear, Fashion & Accessories | AJIO",
				"Title not matched!!");

	}

	@Test(description = "To verify Page is redirecting to \"Online Shopping for Men – Clothing, Footwear, Fashion & Accessories | AJIO\" Page after clicking on \"SHOP MEN\" Link on homepage")
	public static void ajio_003() {
		click("shopMen");
		expllicitWait(8, "SECONDS");
		Assert.assertEquals(getTitle(), "Online Shopping for Men – Clothing, Footwear, Fashion & Accessories | AJIO",
				"Title not matched!!");

	}

	@Test(description = "To verify Page is redirecting to \"Online Kids fashion shopping site in India - AJIO\" Page after clicking on \"SHOP KIDS\" Link on homepage")
	public static void ajio_004() {
		click("shopKids");
		expllicitWait(8, "SECONDS");
		Assert.assertEquals(getTitle(), "Online Kids fashion shopping site in India - AJIO", "Title not matched!!");

	}

	@Test(description = "To verify Page is redirecting to \"AJIO\" Page after clicking on \"SHOP SALE\" Link on homepage")
	public static void ajio_005() {
		click("shopSale");
		expllicitWait(8, "SECONDS");
		Assert.assertEquals(getTitle(), "AJIO", "Title not matched!!");

	}
	@Test(description = "To verify signUp Modal Pop Up window   is opening  after clicking on \"signIn/JoinAjio\" Link on homepage")
	public static void ajio_006() {
		click("signIn/JoinAjio");
		expllicitWait(8, "SECONDS");
		Assert.assertTrue(isDisplayed("signUpModalPopUp"), "SignIn/SignUp Modal PopUp Not Present on page !!");

	}
	@Test(description = "To verify Page is redirecting to \"AJIO\" Page after clicking on \"SHOP SALE\" Link on homepage")
	public static void ajio_007() {
		click("customerCare");
		expllicitWait(8, "SECONDS");
		Assert.assertEquals(getTitle(), "AJIO", "Title not matched!!");

	}

	@AfterMethod
	public static void tearDown() {
		closeBrowserWindow();
	}
}
