package com.ajio.keyword;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.KeyForType;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestResult;

import com.ajio.constant.Constant;
import com.ajio.customUtil.CustomUtil;
import com.ajio.testCases.SignUp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyword extends Constant {
	public static Logger log = Logger.getLogger(Keyword.class);

	/**
	 * 
	 * This method will open browser window
	 * 
	 * @param browserName
	 */
	public static void openBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().version("2.40").setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "opera":
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:

			log.info("Entered  Browser Name not matched!!");
			break;

		}
		log.info(browserName + " is opened!! ");

	}

	/**
	 * This Method will Maximised the opened Browser Window
	 */
	public static void maxiBrowserWindow() {
		driver.manage().window().maximize();
		log.info("Maximized Browser Window!!");
	}

	/**
	 * This method will launch specified url on browser window
	 * 
	 * @param url
	 */
	public static void launchURL(String url) {
		driver.get(url);
		log.info(url + " is launched!!");
	}

	/**
	 * This method will delete all cookies
	 */
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		log.info("Deleted All Cookies!!");
	}

	/**
	 * Sets the amount of time to wait for a page load to complete
	 * 
	 * @param duration
	 *            :time
	 * @param timeUnit
	 *            :Unit
	 */
	public static void pageLoadTimeOut(long duration, String timeUnit) {
		switch (timeUnit) {
		case "NANOSECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MICROSECONDS);
			break;
		case "MILLISECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			driver.manage().timeouts().pageLoadTimeout(duration, TimeUnit.DAYS);
			break;
		default:
			log.info("Entered Time Unit  Not Matched!!");
			break;
		}
		log.info(duration + timeUnit + " Page load timeout  is applied!!");
	}

	/**
	 * Specifies the amount of time the driver should wait when searching for an
	 * element if it isnot immediately present.
	 * 
	 * @param duration
	 *            :time
	 * @param timeUnit
	 *            :Unit
	 */

	public static void implicitWait(long duration, String timeUnit) {
		switch (timeUnit) {
		case "NANOSECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MICROSECONDS);
			break;
		case "MILLISECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			driver.manage().timeouts().implicitlyWait(duration, TimeUnit.DAYS);
			break;
		default:
			log.info("Entered Time Unit  Not Matched!!");
			break;
		}
		log.info(duration + timeUnit + " Implicit Wait is applied!!");

	}

	public static void expllicitWait(long duration, String timeUnit) {
		switch (timeUnit) {
		case "NANOSECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.NANOSECONDS);
			break;
		case "MICROSECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MICROSECONDS);
			break;

		case "MILLISECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MILLISECONDS);
			break;
		case "SECONDS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.SECONDS);
			break;
		case "MINUTES":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.MINUTES);
			break;
		case "HOURS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.HOURS);
			break;
		case "DAYS":
			wait = new FluentWait(driver);
			wait.withTimeout(duration, TimeUnit.DAYS);
			break;
		default:
			log.info("Entered Time Unit  Not Matched!!");
			break;
		}
		log.info(duration + timeUnit + " Explicit wait is applied!!");
	}

	/**
	 * This method will return weblement
	 * 
	 * @param locatorName
	 * @return
	 */

	public static WebElement getWebElement(String locatorName) {
		log.info("Splitting locatorName: " + locatorName);
		System.out.println("Splitting locatorName: " + locatorName);
		String locatorType = CustomUtil.getLocatorValue(locatorName)[0];
		log.info("Locator Type: " + locatorType);
		System.out.println("Locator Type: " + locatorType);
		String locatorValue = CustomUtil.getLocatorValue(locatorName)[1];
		log.info("Locator Value: " + locatorValue);
		System.out.println("Locator Value: " + locatorValue);
		switch (locatorType) {
		case ("xpath"):
			element = driver.findElement(By.xpath(locatorValue));
			break;
		case ("css"):
			element = driver.findElement(By.cssSelector(locatorValue));
			break;
		case ("id"):
			element = driver.findElement(By.id(locatorValue));
			break;
		case ("name"):
			element = driver.findElement(By.name(locatorValue));
			break;
		case ("className"):
			element = driver.findElement(By.className(locatorValue));
			break;
		case ("tagName"):
			element = driver.findElement(By.tagName(locatorValue));
			break;

		case ("linkText"):
			element = driver.findElement(By.linkText(locatorValue));
			break;
		case ("partialLinkText"):
			element = driver.findElement(By.partialLinkText(locatorValue));
			break;
		}
		return element;

	}

	/**
	 * This method will return Title of currently pointed window
	 * 
	 * @return:Title of current Window
	 */
	public static String getTitle() {
		String title = driver.getTitle();
		log.info(title + "  :Returned Current Webpage Title!!");
		return title;
	}

	/**
	 * This Method will click on webelement
	 * 
	 * @param locatorName
	 */
	public static void click(String locatorName) {
		getWebElement(locatorName).click();
		log.info("Clicked on " + locatorName);
	}

	/**
	 * This method will return the text of weblement which is displyed on webpage
	 * 
	 * @param locatorName
	 * @return
	 */
	public static String getText(String locatorName) {
		String text = getWebElement(locatorName).getText();
		log.info(text + " returned Text !!");
		return text;

	}

	public static void enterText(String locatorName, String text) {
		getWebElement(locatorName).sendKeys(text);

	}

	/**
	 * This Method will return true if the weblement is present in webpage otherwise
	 * false
	 * 
	 * @param locatorName
	 * @return
	 */
	public static boolean isDisplayed(String locatorName) {
		return getWebElement(locatorName).isDisplayed();
	}

	/**
	 * This method will navigate the webpage to back
	 */
	public static void navigateBack() {
		driver.navigate().back();
		log.info("Navigated Back!!");
	}

	/**
	 * This method will navigate the webpage to forward
	 */
	public static void navigateForward() {
		driver.navigate().forward();
		log.info("Navigated Forward!!");
	}

	/**
	 * This method will navigate the webpage to specific webpage
	 */
	public static void navigateTo(String url) {
		driver.navigate().to(url);
		;
		log.info("Navigated to Webpage :  " + url);
	}

	/**
	 * This method will navigate the webpage to back
	 */
	public static void refresh() {
		driver.navigate().refresh();
		log.info("Page Refreshed!!");
	}

	/**
	 * This method will closer Currently pointing Browser window by driver instance
	 */
	public static void closeBrowserWindow() {
		driver.close();
		log.info("Current browser window is Closed!!");
	}

	/**
	 * This method will closer all Browser windows opened by driver instance
	 */
	public static void closeAllBrowserWindows() {
		driver.quit();
		log.info("All browser windows are closed!!");
	}

	/**
	 * This method will take screenshot of Failed Test cases
	 * 
	 * @param tcName
	 */
	public static void failedTCScreenshot(String tcName) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YY");
		Date date = new Date();
		String datetime = dateFormat.format(date);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(source, new File("C:\\Users\\NRK\\javapract\\PriyaRevison\\AjioKDF\\FailedTC\\" + tcName
					+ " dated " + datetime + ".png"));
		} catch (IOException e) {
			log.info("Screenshot file not found!!");
			e.printStackTrace();
		}
		log.info("Screenshot taken Successfully!!");
	}

	/**
	 * This method is used to switch to specified window from if multiple windows
	 * opned
	 */
	public static void windowHandle(String parentWindow, String expWindowTitle) {
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			System.out.println("Titles: " + driver.switchTo().window(window).getTitle());
			if (driver.switchTo().window(window).getTitle().equals(expWindowTitle)) {
				System.out.println("Swicthed To Chiled Window: " + expWindowTitle);
				break;
			}
		}
	}

	public static void switchParentWindow(String parentWindow) {
		driver.switchTo().window(parentWindow);
		System.out.println("Swicthed to Parent  window:  " + parentWindow);

	}

	public static void mouseHoverAndClick(String locatorName) {
		action = new Actions(driver);
		action.moveToElement(getWebElement(locatorName)).click().build().perform();

	}

	public static int getCountFromString(String text, String remove) {
		String count = getText(text).replace(remove, "").replace(",","");
		return Integer.parseInt(count);
	}
}
