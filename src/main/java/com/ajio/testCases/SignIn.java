package com.ajio.testCases;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.keyword.Keyword;

@Listeners(com.ajio.listner.Listener.class)
public class SignIn extends Keyword {

	@BeforeMethod
	public static void setUp() {
		openBrowser("chrome");
		maxiBrowserWindow();
		launchURL("https://www.ajio.com");
		deleteAllCookies();
		pageLoadTimeOut(20, "SECONDS");
		implicitWait(20, "SECONDS");
	}

	@Test(description = "To verify unsuccesfull signIn when   Mobile Number / Email* field is  kept blank and   showing as Please enter valid Mobile Number / Email.")
	public static void ajio_023() {
		click("signIn/JoinAjio");
		click("continue");
		Assert.assertEquals(getText("emailErrorMsg"), "Please enter valid Mobile Number / Email.",
				"Error Message  not matched!!");
	}

	@Test(description = "To verify unsuccesfull signIn when   Password  field is  kept blank and   showing as Please enter valid Mobile Number / Email.")
	public static void ajio_024() {
		click("signIn/JoinAjio");
		enterText("email", "ukundepriya@gmail.com");
		click("continue");
		click("startShopping");
		Assert.assertEquals(getText("passErrorMsg1"), "Please enter a valid password",
				"Password Error Message  not matched!!");
	}

	@Test(description = "To verify unsuccesfull signIn after entering  invalid email/mobile number in   Mobile Number / Email* field  and   showing as Please enter valid Mobile Number / Email.")
	public static void ajio_025() {
		click("signIn/JoinAjio");
		enterText("email", "invalid");
		click("continue");
		Assert.assertEquals(getText("emailErrorMsg"), "Please enter a valid Mobile Number/Email.",
				"Error Message  not matched!!");
	}

	// Problem :sometimes without captcha we can login and showing this password
	// error message but with captch message is diffrent as ajio_027 tc , if captch
	// not available the shows error ,essage(Wrong Password Entered)

	@Test(description = "To verify unsuccesfull signIn after  entering valid email id / mobile number and  invalid    Password   and   showing as Wrong Password Entered an d when captch available the shows Please enter correct password and captcha")
	public static void ajio_026() {
		click("signIn/JoinAjio");
		enterText("email", "ukundepriya@gmail.com");
		click("continue");
		enterText("loginpassword", "invalid");
		click("startShopping");
		expllicitWait(3, "SECONDS");
		Assert.assertEquals(getText("passErrorMsg2"), "Wrong Password Entered",
				"Password Error Message  not matched!!");
	}

	// Problem: Sometime times without captcha we can signIn successfullly
	// butsometimes captch is showing so we can't
	@Test(description = "To verify succesfull signIn after  entering valid email id / mobile number and  valid     Password  ")
	public static void ajio_027() {
		click("signIn/JoinAjio");
		enterText("email", "ukundepriya@gmail.com");
		click("continue");
		enterText("loginpassword", "Priya123@");
		click("startShopping");
		expllicitWait(10, "SECONDS");
		try {
			Assert.assertTrue(isDisplayed("signOut"), "unsuccessfull login");
			}catch (StaleElementReferenceException  e) {
				driver.navigate().refresh();
			}
	}

	// OR
	// Assert.assertEquals(getText("captchaMsg"), "Please enter correct password and
	// captcha","Message missmatched!!");

	@Test(description = "To verify succesfull signIn with valid facebook credentials")
	public static void ajio_028() {
		click("signIn/JoinAjio");
		String parentWindow = driver.getWindowHandle();
		click("facebookSignIn");
		expllicitWait(5, "SECONDS");
		windowHandle(parentWindow, "Facebook");
		enterText("facebookEmail", "ukundepriya@gmail.com");
		enterText("facebookPass", "PNDCK");
		click("facebookLogin");
		expllicitWait(10, "SECONDS");
		switchParentWindow(parentWindow);
		try {
			Assert.assertTrue(isDisplayed("signOut"), "unsuccessfull login");
			}catch (StaleElementReferenceException  e) {
				driver.navigate().refresh();
			}

	}

	/*
	 * //Problem:Can't click on googleSign
	 * 
	 * @Test(description =
	 * "To verify succesfull signIn with valid gmail credentials") public static
	 * void ajio_029() { click("signIn/JoinAjio"); String parentWindow =
	 * driver.getWindowHandle(); expllicitWait(3, "SECONDS");
	 * mouseHoverAndClick("googleSignIn"); expllicitWait(5, "SECONDS");
	 * windowHandle(parentWindow, "Sign in – Google accounts");
	 * enterText("googleEmail", "ukundepriya@gmail.com"); click("googleNext");
	 * enterText("googlePass", "Priya123"); click("googleNext");
	 * 
	 * expllicitWait(10, "SECONDS"); switchParentWindow(parentWindow);
	 * Assert.assertTrue(isDisplayed("signOut"), "unsuccessfull login");
	 * 
	 * }
	 */

	@AfterMethod
	public static void tearDown() {
		closeBrowserWindow();
	}

}
