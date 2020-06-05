package com.ajio.PageTests;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.Pages.FooterPage;
//Keyword: Is used to call generalized methods
//Page: Is used to call project specific methods 
import com.ajio.Pages.HomepagePage;

@Listeners(com.ajio.listner.Listener.class)
public class FooterPageTests extends FooterPage {
	Logger log = Logger.getLogger(FooterPageTests.class);
	public static FooterPage test;

	@BeforeMethod
	public static void setUp() {
		openBrowser("chrome");
		maxiBrowserWindow();
		test = PageFactory.initElements(driver, FooterPage.class);
		launchURL("https://www.ajio.com");// nessesary to write afre initialization of pacgefactory
		deleteAllCookies();
		pageLoadTimeOut(20, "SECONDS");
		implicitWait(20, "SECONDS");

	}
	// Usability Testing

	@Test(description = "To verify title of homepage", groups = "Usability Testing")
	public static void verify_Homepage_Title() {
		Assert.assertEquals(getTitle(), "Online Shopping for Women, Men, Kids – Clothing, Footwear, Fashion | AJIO",
				"Homepage Title not matched!!");

	}
}
