package vtigetautomation;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ER {

	public static void verifyCreateLead() throws IOException {

		DateFormat df = new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
		String timeStamp = df.format(new Date());

		ExtentSparkReporter esr = new ExtentSparkReporter("Automationreport" + timeStamp + ".html");
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(esr);
		ExtentTest extTest = ext.createTest("verify create lead");

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		extTest.log(Status.INFO, "Chrome Browser Has been launched successfully");

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
//		driver.get("localhost:8888/");
		extTest.log(Status.INFO, "http://localhost:8888/ opened successfully");

		enterTextboxValue(driver, extTest, "//input[@name='user_name']", "user name", "admin");
		enterTextboxValue(driver, extTest, "//input[@name='user_password']", "Password", "admin");
//		click(driver, extTest, "//inpu[@name='Login']", "Login Button");

	}

	/// generic method - application independent util methods wrapper methods
	public void verifySearchLeads() {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
		String timeStamp = df.format(new Date());

		ExtentSparkReporter esr = new ExtentSparkReporter("Automationreport" + timeStamp + ".html");
		ExtentReports ext = new ExtentReports();
		ext.attachReporter(esr);
		ExtentTest extTest = ext.createTest("verify search lead");
	}

	public static void enterTextboxValue(WebDriver driver, ExtentTest extTest, String locator, String elementName,
			String dataValue) throws IOException {
		try {
			WebElement we = driver.findElement(By.xpath(locator));
			if (we.isDisplayed() == true) {
				extTest.log(Status.INFO, "user name text box is  visible");
				if (we.isEnabled() == true) {
					extTest.log(Status.INFO, elementName + " text box is  enabled");
					we.sendKeys(dataValue);
					extTest.log(Status.INFO,
							dataValue + " has been entered in " + elementName + " textbox successfully");

				} else {
					extTest.log(Status.INFO, elementName + " text box is  disabled");
				}
			} else {
				extTest.log(Status.FAIL, elementName + " text box is not visible");
			}
		} catch (Exception e) {
			MyUtil.screenshot( dataValue);

		}

	}

	public static void click(WebDriver driver, ExtentTest extTest, String locator, String elementName)throws IOException {
		try {
			WebElement wbet = driver.findElement(By.xpath(locator));
			if (wbet.isDisplayed() == true) {
				extTest.log(Status.INFO, elementName + "user name text box is  visible");
				if (wbet.isEnabled() == true) {
			 		extTest.log(Status.INFO, elementName + " text box is  enabled");
					wbet.click();
					extTest.log(Status.INFO, "click performed successfully on " + elementName);

				} else {
//					extTest.log(Status.INFO, elementName + " text box is  disabled");
				}
			} else {
				extTest.log(Status.FAIL, elementName + " text box is not visible");
			}
		} catch (Exception e) {
			MyUtil.screenshot(elementName);

		}

	}
	public static void click(WebDriver driver,String xpath) {
		WebElement we = driver.findElement(By.xpath(xpath));
	}
}
