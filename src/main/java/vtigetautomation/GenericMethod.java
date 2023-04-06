package vtigetautomation;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericMethod {
public static void main(String[] args) {
	
}
		public void verifyCreateLead() {

			DateFormat df= new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
			String timeStamp=df.format(new Date());

			ExtentSparkReporter esr=new ExtentSparkReporter("Automationreport"+timeStamp+".html");
			ExtentReports ext=new ExtentReports();
			ext.attachReporter(esr);
			ExtentTest extTest=ext.createTest("verify create lead");

			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			extTest.log(Status.INFO, "Chrome Browser Has been launched successfully");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60000));
			driver.get("localhost:8888/");
			extTest.log(Status.INFO, "http://localhost:8888/ opened successfully");

			enterTextboxValue(driver, extTest, "user_name", "name" ,"user name", "admin");
			enterTextboxValue(driver, extTest, "input[name='user_password']", "css", "Password", "admin");
			click(driver, extTest, "//input[@name='Login']", "xpath" , "Login Button");
			click(driver, extTest, "Marketing", "linkText" , "Login Button");


		}
		///   generic method  -  application independent util methods wrapper methods 
		public void verifySearchLeads() {
			DateFormat df= new SimpleDateFormat("MM_dd_yyyy___HH_mm_ss");
			String timeStamp=df.format(new Date());

			ExtentSparkReporter esr=new ExtentSparkReporter("Automationreport"+timeStamp+".html");
			ExtentReports ext=new ExtentReports();
			ext.attachReporter(esr);
			ExtentTest extTest=ext.createTest("verify search lead");
		}

		//////
		
		public static WebElement getWebElement(WebDriver driver,ExtentTest extTest, String locatorValue , String locatorType) {
			WebElement we=null;
			///  we are checking locator Type value is xpath or not
			if(locatorType.equalsIgnoreCase("xpath")) {
				////  if it is xpath then it using 
				we=driver.findElement(By.xpath(locatorValue));	
				
				///  
			}else if(locatorType.equalsIgnoreCase("linkText")) {
				we=driver.findElement(By.linkText(locatorValue));	
			}else if(locatorType.equalsIgnoreCase("name")) {
				we=driver.findElement(By.name(locatorValue));	
			}else if(locatorType.equalsIgnoreCase("id")) {
				we=driver.findElement(By.id(locatorValue));	
			}else if(locatorType.equalsIgnoreCase("class")) {
				we=driver.findElement(By.className(locatorValue));	
			}else if(locatorType.equalsIgnoreCase("css")) {
				we=driver.findElement(By.cssSelector(locatorValue));	
			}else {
				extTest.log(Status.FAIL,locatorType+" Locator Type is Wrong. Please check");
			}
			return we;
		}

		public static void enterTextboxValue(WebDriver driver, ExtentTest extTest, String locatorValue, String locatorType, String elementName, String dataValue) {
			try {
	             WebElement we=getWebElement(driver, extTest, locatorValue, locatorType);
	             boolean st=checkElement(we, extTest, elementName);
			     if(st==true) {
			    	 we.sendKeys();
			     }
			}catch(Exception e) {
				takeScreenshot();
			}
		}
		
		public static void selectByText(WebDriver driver, ExtentTest extTest, String locatorValue, String locatorType, String elementName, String textToSelect) {
			try {
	            WebElement we=getWebElement(driver, extTest, locatorValue, locatorType);
	            boolean st=checkElement(we, extTest, elementName);
			     if(st==true) {
			    	 Select selectObj = new Select(we);
			    	 selectObj.selectByVisibleText(textToSelect);;
			     }
			}catch(Exception e) {
				takeScreenshot();
			}
		}
		public static void selectByValueAttribute(WebDriver driver, ExtentTest extTest, String locatorValue, String locatorType, String elementName, String valueAttributeToSelect) {
			try {
	            WebElement we=getWebElement(driver, extTest, locatorValue, locatorType);
	            boolean st=checkElement(we, extTest, elementName);
			     if(st==true) {
			    	 Select selectObj = new Select(we);
			    	 selectObj.selectByValue(valueAttributeToSelect);;
			     }
			}catch(Exception e) {
				takeScreenshot();
			}
		}	
		
		public static String getInnerText(WebDriver driver, ExtentTest extTest, String locatorValue, String locatorType, String elementName, String valueAttributeToSelect) {
			String innerText=null;
			try {
	            WebElement we=getWebElement(driver, extTest, locatorValue, locatorType);
	            boolean st=checkElement(we, extTest, elementName);
			     if(st==true) {
			    	innerText=we.getText();
			     }
			}catch(Exception e) {
				takeScreenshot();
			}
			return innerText;
		}
		
		////  getTe
		
		
		
		
	    public static void takeScreenshot() {
	    	
	    }

		public static void click(WebDriver driver, ExtentTest extTest, String locatorValue,String locatorType, String elementName) {
			try {
				WebElement we=getWebElement(driver, extTest, locatorValue, locatorType);
	             boolean st=checkElement(we, extTest, elementName);
			     if(st==true) {
			    	 we.click();
			     }    
			}catch(Exception e) {
				TakesScreenshot tss=(TakesScreenshot)driver;
				File fileObj=tss.getScreenshotAs(OutputType.FILE);

			}

		}

		/* checkElement method is made to verify whether element is actionable or not 
		 * parameters-
		 * WebElement - we -  ELement On which we want to perform action.
		 * 
		 * return - boolean
		 * */
		public static boolean checkElement(WebElement we, ExtentTest extTest, String elementName) {
			boolean status=false;
			/// we are checking element is displaying or not. if it is displaying then it is going into if condition
			if(we.isDisplayed()==true) {
				
				extTest.log(Status.INFO, "user name text box is  visible");
				//// we 
				if(we.isEnabled()==true) {
					extTest.log(Status.INFO, elementName+" text box is  enabled");
				     /// if element is visible and enabled then it is assigning true value
					status=true;
				}else {
					extTest.log(Status.INFO, elementName+" text box is  disabled");
				}
			}else {
				extTest.log(Status.FAIL, elementName+" text box is not visible");
			}
			return status;
		}
		
		
		


	}


