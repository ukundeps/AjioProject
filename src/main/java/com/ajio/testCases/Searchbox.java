package com.ajio.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ajio.keyword.Keyword;

public class Searchbox extends Keyword  {
	@BeforeMethod
	public static void setUp() {
		openBrowser("chrome");
		maxiBrowserWindow();
		launchURL("https://www.ajio.com");
		deleteAllCookies();
		pageLoadTimeOut(20, "SECONDS");
		implicitWait(20, "SECONDS");
	}
	@Test(description="To verify  result contains  the Searched Product Category Name after searching  Product by Category in search box ")
	public static  void ajio_031() {
		click("collection");
		enterText("searchBox", "T-shirt");
		click("submit");
		expllicitWait(5, "SECONDS");
		int resultCount=getCountFromString("resultTotalCount"," Items Found");
	
		
	}
	
	/*@AfterMethod
	public static void tearDown() {
		closeBrowserWindow();
	}*/

}
