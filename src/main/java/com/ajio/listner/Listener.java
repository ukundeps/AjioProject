package com.ajio.listner;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ajio.keyword.Keyword;

public class Listener implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case Execution Started : " + result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case Execution Successed : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Test Case Execution Failed : " + result.getName());
		Keyword.failedTCScreenshot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case Execution Skipped : " + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
