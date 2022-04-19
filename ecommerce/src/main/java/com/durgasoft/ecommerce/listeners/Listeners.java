package com.durgasoft.ecommerce.listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.durgasoft.ecommerce.basepage.BasePage;

public class Listeners extends BasePage implements ITestListener {

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test start running:" + arg0.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult arg0) {
		Reporter.log("Test is success:" + arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodname = arg0.getName();
		if (arg0.isSuccess()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String reportdirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/durgasoft/ecommerce");
			File target = new File((String) reportdirectory + "/passedscreens/" + methodname + "_"
					+ simpledate.format(cal.getTime()) + ".png");
			try {
				FileUtils.copyFile(src, target);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Test is failed:" + arg0.getMethod().getMethodName());
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodname = arg0.getName();
		if (!arg0.isSuccess()) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String reportdirectory = (new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "/src/main/java/com/durgasoft/ecommerce");
			File target = new File((String) reportdirectory + "/failedscreens/" + methodname + "_"
					+ simpledate.format(cal.getTime()) + ".png");
			try {
				FileUtils.copyFile(src, target);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
