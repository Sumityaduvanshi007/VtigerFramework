package vtigetautomation;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class MyUtil {
	public static WebDriver driver;
	public static ExtentTest extTest;

	public static void screenshot(String fileName) {
		Date currentDate = new Date();
		TakesScreenshot tScreenshot1 = (TakesScreenshot) driver;
		File form1 = tScreenshot1.getScreenshotAs(OutputType.FILE);
		File to1 = new File(fileName + currentDate.toString().replace(":", "_") + ".png");
		try {
			Files.copy(form1, to1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extTest.addScreenCaptureFromPath(to1.getAbsolutePath());
	}

	public Dimension getTheSizeOfElement(String locatorValue, String locatorType, String elementName){
		Dimension dnObj = null;
		try {
			WebElement we = getWebElement(locatorValue, locatorType, elementName);
			boolean status = checkElement(locatorValue, locatorType, elementName);
			if (status == true) {
				dnObj = we.getSize();
				int h = dnObj.getHeight();
				int w = dnObj.getWidth();
				extTest.log(Status.INFO, " getTheSize this Element " + elementName + " Height is = " + h + " Widht is = " + w);
			} else {
				extTest.log(Status.INFO, "Not getTheSize this Element" + elementName);
			}
		} catch (Exception e) {
			screenshot(elementName);
		}
		return dnObj;
	}

	public Point getTheLocationOfElement(String locatorValue, String locatorType, String elementName) {
			
		Point ptobj = null;
		try {
			WebElement we = getWebElement(locatorValue, locatorType, elementName);
			boolean status = checkElement(locatorValue, locatorType, elementName);
			if (status == true) {
				ptobj = we.getLocation();
				int x = ptobj.x;
				int y = ptobj.y;
				extTest.log(Status.INFO, "getTheLocation this Element" + elementName + " X- = " + x + " Y- = " + y);
			} else {
				extTest.log(Status.INFO, "Not getTheLocation this Element" + elementName);
			}
		} catch (Exception e) {
			screenshot(elementName);
			;
		}
		return ptobj;
	}

	public WebElement getWebElement(String locatorValue, String locatorType, String elementName) {
		WebElement we = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			we = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			we = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			we = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			we = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			we = driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			we = driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("innerTest")) {
			we = driver.findElement(By.linkText(locatorValue));
		} else {
			extTest.log(Status.FAIL, elementName + "wrong xpath");
		}
		return we;
	}

	public boolean checkElement(String locatorValue, String locatorType, String elementName) {
		boolean status = false;
		WebElement we = getWebElement(locatorValue, locatorType, elementName);
		if (we.isDisplayed()) {
			extTest.log(Status.PASS, elementName + " element is Displayed");
			if (we.isEnabled()) {
				extTest.log(Status.PASS, elementName + " element is Enabled");
				status = true;
			} else {
				extTest.log(Status.FAIL, elementName + " element is not Enabled");
			}
		} else {
			extTest.log(Status.FAIL, elementName + " element is not Displayed");
		}
		return status;
	}

	public ExtentReports genaretReports(String testCaseId) {
		DateFormat df = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String dateStamp = df.format(new Date());
		File filePath = new File("target" + dateStamp + ".html");
		ExtentSparkReporter esp = new ExtentSparkReporter(filePath);
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(esp);
		extTest = ext.createTest(testCaseId);
		System.out.println("HelloReports");
		return ext;
	}
	public void launchBrowser(WebDriver browserName,String url) {
		driver = browserName;
		driver.get(url);
	}
	
	
}
