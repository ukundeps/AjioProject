package com.ajio.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ajio.keyword.Keyword;

@Listeners(com.ajio.listner.Listener.class)
public class SignUp extends Keyword {

	@BeforeMethod
	public static void setUp() {
		openBrowser("chrome");
		maxiBrowserWindow();
		launchURL("https://www.ajio.com");
		deleteAllCookies();
		pageLoadTimeOut(20, "SECONDS");
		implicitWait(20, "SECONDS");
	}

	@Test(description = "To verify    Enter Mobile Number / Email* field  is not kept blank  and if kept blank then  showing as Please enter valid Mobile Number / Email.")
	public static void ajio_008() {
		click("signIn/JoinAjio");
		click("continue");
		Assert.assertEquals(getText("emailErrorMsg"), "Please enter valid Mobile Number / Email.",
				"Error Message  not matched!!");
	}

	@Test(description = "To verify after entering registered email id and clicking on continue buttion LoginForm is displayed")
	public static void ajio_009() {
		click("signIn/JoinAjio");
		enterText("email", "ukundepriya@gmail.com");
		click("continue");
		Assert.assertTrue(isDisplayed("loginForm"), " Login form not displayed ");

	}

	@Test(description = "To verify after entering unregistered email id and clicking on continue buttion SignUpForm is displayed")
	public static void ajio_010() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		Assert.assertTrue(isDisplayed("signUpForm"), " SignUp  form not displayed ");
	}

	@Test(description = "To verify name text field is  blank and  showing error  message as Use only alphabets and an optional single space between words.")
	public static void ajio_011() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		//enterText("name", "");
		click("sendOTP");
		Assert.assertEquals(getText("nameErrorMsg"), "Use only alphabets and an optional single space between words.",
				"Name feidl Error message not matched");
	}

	@Test(description = "To verify name text feild is not accepting non-alphabetic characters and  showing error  message as Use only alphabets and an optional single space between words.")
	public static void ajio_012() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("name", "Priya123@");
		click("sendOTP");
		Assert.assertEquals(getText("nameErrorMsg"), "Use only alphabets and an optional single space between words.",
				"Name feidl Error message not matched");
	}

	@Test(description = "To verify name text feild is not starting with  space  and  showing error  message as Use only alphabets and an optional single space between words")
	public static void ajio_013() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("name", " Ritu");
		click("sendOTP");
		Assert.assertEquals(getText("nameErrorMsg"), "Use only alphabets and an optional single space between words.",
				"Name feidl Error message not matched");
	}

	@Test(description = "To verify name text feild is not accepting more than one space inbetween name   and  showing error  message as Use only alphabets and an optional single space between words")
	public static void ajio_014() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("name", "Ritu  Ukunde");
		click("sendOTP");
		Assert.assertEquals(getText("nameErrorMsg"), "Use only alphabets and an optional single space between words.",
				"Name feidl Error message not matched");
	}

	@Test(description = "To verify Mobile  text field is not blank  and showing error  message as Please enter a valid Mobile number. ")
	private void ajio_015() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		//enterText("mobile", "");
		click("sendOTP");
		Assert.assertEquals(getText("mobileErrorMsg"), "Please enter a valid Mobile number.",
				"Mobile field error message not matched");

	}

	@Test(description = "To verify Mobile  text field is not accepting  numbers less than 10 digits and showing error  message as Please enter a valid Mobile number. ")
	private void ajio_016() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("mobile", "738524302");
		click("sendOTP");
		Assert.assertEquals(getText("mobileErrorMsg"), "Please enter a valid Mobile number.",
				"Mobile field error message not matched");

	}

	@Test(description = "To verify Mobile  text field is not accepting  numbers more  than 10 digits and showing error  message as Please enter a valid Mobile number. ")
	private void ajio_017() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("mobile", "73852430290");
		click("sendOTP");
		Assert.assertEquals(getText("mobileErrorMsg"), "Please enter a valid Mobile number.",
				"Mobile field error message not matched");

	}

	@Test(description = "To verify   Password  text field is not kept blank  and if kept blank showing error  message as Password should have a minimum of 8 characters with atleast one number, one alphabet and one special character. ")
	private void ajio_018() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
	//	enterText("password", "");
		click("sendOTP");
		Assert.assertEquals(getText("passErrorMsg"),
				"Password should have a minimum of 8 characters with atleast one number, one alphabet and one special character.",
				"Password  field error message not matched");

	}

	@Test(description = "To verify Password  text field is not accepting less than 8 digits password  and showing error  message as Password should have a minimum of 8 characters with atleast one number, one alphabet and one special character. ")
	private void ajio_019() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("password", "Ritu12");
		click("sendOTP");
		Assert.assertEquals(getText("passErrorMsg"),
				"Password should have a minimum of 8 characters with atleast one number, one alphabet and one special character.",
				"Password  field error message not matched");

	}

	@Test(description = "To verify Password  text field is accepting atleast one number, one alphabet and one special character and if not then   showing error  message as Password should have a minimum of 8 characters with atleast one number, one alphabet and one special character. ")
	private void ajio_020() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("password", "Ritu12345");
		click("sendOTP");
		Assert.assertEquals(getText("passErrorMsg"),
				"Password should have a minimum of 8 characters with atleast one number, one alphabet and one special character.",
				"Password  field error message not matched");

	}

	@Test(description = "To verify Terms and conditions checkbox is checked complusary   otherwise it is  showing error  message as You must agree to Terms and Conditions ")
	private void ajio_021() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		// click("termsAndCond");
		click("sendOTP");
		Assert.assertEquals(getText("tncErrorMsg"), "You must agree to Terms and Conditions",
				"Terms and Condition   error message not matched");

	}

	@Test(description = "To verify successfull signUp after entering  all valid mandetory infoemation in signup form ")
	private void ajio_022() {
		click("signIn/JoinAjio");
		enterText("email", "ukunderitu@gmail.com");
		click("continue");
		enterText("name", "Ritu Ukunde");
		enterText("mobile", "7385243028");
		enterText("password", "Ritu12345@");
		click("termsAndCond");
		click("sendOTP");
		Assert.assertTrue(isDisplayed("numberVerification"), "Unsuccessfull signUp!!");

	}

	@AfterMethod
	public static void tearDown() {
		closeBrowserWindow();
	}

}
