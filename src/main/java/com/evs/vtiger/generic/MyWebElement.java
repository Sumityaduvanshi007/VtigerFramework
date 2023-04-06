package com.evs.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class MyWebElement {
	public static ExtentTest extesTes;
	public static WebDriver driver;

	public static void main(String[] args) {
 
	   
//		ExtentReport("BrowserLounching", "os.name", "User name", "Tc001");
//		enterTextboxValue1(null, "", "userBox","admin");
	}

	/**
	 * 
	 * @param fileName
	 * @param OsName
	 * @param UserName
	 * @param TcId
	 */
	@Test
	public static void ExtentReport(String fileName, String OsName, String UserName, String TcId) {
		File objfile = new File(fileName + ".html");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(objfile);
		ExtentReports ExtReport = new ExtentReports();
		ExtReport.attachReporter(htmlReport);
		ExtReport.setSystemInfo("OS Name", System.getProperty(OsName));
		ExtReport.setSystemInfo("UserName", System.getProperty(UserName));
		ExtReport.setSystemInfo("Server name", "Qa Server");
		extesTes = ExtReport.createTest(TcId);
		try {

			lounchBrowser(new ChromeDriver(), "http:localhost:8888");
		} catch (Exception e) {
			e.printStackTrace();
		}

		ExtReport.flush();
	}

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
		extesTes.addScreenCaptureFromPath(to1.getAbsolutePath());
	}

	public static void lounchBrowser(WebDriver browserName, String url) {
		try {
			driver = browserName;
			extesTes.log(Status.INFO, "Browser lounch succesfully");
			driver.get(url);
			extesTes.log(Status.INFO, "Url hit succesfully");
		} catch (Exception e) {
			driver.navigate().to(url);
			screenshot("BrowserLounching");
			
			e.printStackTrace();
		}
	}

	public static boolean checkElement(WebElement we, String elementName) {
		boolean status = false;
		if (we.isDisplayed() == true) {
			extesTes.log(Status.INFO, "user name text box is  visible");
			if (we.isEnabled() == true) {
				extesTes.log(Status.INFO, elementName + " text box is  enabled");
				status = true;
			} else {
				extesTes.log(Status.INFO, elementName + " text box is  disabled");
			}
		} else {
			extesTes.log(Status.FAIL, elementName + " text box is not visible");
		}
		return status;
	}

	public static void clickEle1ment(String locatorValue, String locatorType, String elementName)  {
		try {
			WebElement we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				Actions ac = new Actions(driver);
				ac.click().build().perform();
			}
		} catch (Exception e) {
			screenshot(elementName);
			e.printStackTrace();
		}

	}

	public static String getInnerText(WebDriver driver, ExtentTest extTest, String locatorValue, String locatorType,
			String elementName, String valueAttributeToSelect){
		String innerText = null;
		try {
			WebElement we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				innerText = we.getText();
			}
		} catch (Exception e) {
			screenshot(innerText);
		}
		return innerText;
	}

	public static WebElement getWebElement(String locatorValue, String locatorType) {
		WebElement we = null;
		if (locatorType.equalsIgnoreCase("xpath")) {
			we = driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linkText")) {
			we = driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.equalsIgnoreCase("name")) {
			we = driver.findElement(By.name(locatorValue));
		} else if (locatorType.equalsIgnoreCase("id")) {
			we = driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			we = driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			we = driver.findElement(By.cssSelector(locatorValue));
		} else {
			extesTes.log(Status.FAIL, locatorType + " Locator Type is Wrong. Please check");
		}
		return we;
	}

	public static void enterTextboxValue1(String locatorValue, String locatorType, String elementName, String dataValue)
			throws IOException {
		try {
			WebElement we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				we.sendKeys();
			}
		} catch (Exception e) {
			screenshot(dataValue);
		}

	}

	public static void sendValue(String locatorValue, String locatorType, String elementName,String SendVelue) {
		try {
			WebElement we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				Actions ac = new Actions(driver);
				ac.sendKeys(SendVelue).build().perform();
			}
		} catch (Exception e) {
			screenshot(elementName);
		}
		

	}
	public static void sendValue(String locatorValue, String locatorType, String elementName,WebElement we,String SendVelue) {
		try {
			 we = getWebElement(locatorValue, locatorType);
			boolean st = checkElement(we, elementName);
			if (st == true) {
				Actions ac = new Actions(driver);
				ac.sendKeys(we,SendVelue).build().perform();
			}
		} catch (Exception e) {
			screenshot(elementName);
		}
		

	}
	public static void hendleframe(int indexNo) {
		driver.switchTo().frame(indexNo);
	}
	public static void hendleframe(String idOrname) {
		driver.switchTo().frame(idOrname);
	}
	public static void hendleframe(WebElement we) {
		driver.switchTo().frame(we);
	}
	
}
