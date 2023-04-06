package vtigetautomation;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Verify {

	public static void main(String[] args) {
//	s	Collections a= new Collections();
//		WebDriver driver = new ChromeDriver()
//		driver.get("http://localhost:8888/");
  // System.setProperty("webdriver.chrome.driver", "C:\\Users\\nituy\\eclipse-workspace\\Selenium\\file\\chromedriver_win32 (4)\\chromedriver.exe");
		ChromeOptions cp = new ChromeOptions();
        WebDriver driver = new ChromeDriver(cp);
		String hndl = driver.getWindowHandle();
		driver.get("http://localhost:8888/");
		WebElement a = driver.findElement(By.name("user_name")); /// a - webELement object
		a.sendKeys("admin");
		By byPassword = By.name("user_password");
		WebElement pwdObj = driver.findElement(byPassword);
		pwdObj.sendKeys("admin");
		By byLogin = By.name("Login");
		WebElement loginButton = driver.findElement(byLogin);
		loginButton.click(); //// indexing

		driver.findElement(By.linkText("Feedback")).click();
		driver.findElement(By.linkText("About Us")).click();

		driver.findElement(By.linkText("Help")).click();

		Set<String> getValue=driver.getWindowHandles();
        for (String string:getValue) {
       	 driver.switchTo().window(string);///ek win
       	 String gettitle=driver.getTitle();
      	 System.out.println(gettitle);
       	 if(gettitle.equalsIgnoreCase("admin - My Home Page - Home - vtiger CRM 5 - Commercial Open Source CRM")==false) {
       		 driver.close();
       		 
       	 }	
		}			
		}
//       		 driver.findElement(By.name("description")).sendKeys("Hello this is good application");
//    	 }else 
//    		 if(getTitle.equalsIgnoreCase("Vtiger CRM -vtiger")) {
////		driver.findElement(By.name("description")).sendKeys(" It is a good application ");
//		Set<String> handleValueSet = driver.getWindowHandles();
//		for (String hndlValue: handleValueSet) {
//			driver.switchTo().window(hndlValue);
//			String title =driver.getTitle();
//       	 }else if(getTitle.equalsIgnoreCase("vtiger CRM 5 - Free, Commercial grade Open Source CRM")) {
//       		 driver.close();
//       	 }else if(getTitle.equalsIgnoreCase("vtiger CRM 5 - Free, Commercial grade Open Source CRM")) {
//       		 
//       		 driver.findElement(By.linkText("Marketing")).click();
	
//		WebElement webname = driver.findElement(By.name("user_name"));
//		webname.sendKeys("admin");
//
//		WebElement webpass = driver.findElement(By.name("user_password"));
//		webpass.sendKeys("admin");
//
//		driver.findElement(By.name("Login")).click();
//
//		List<WebElement> link = driver.findElements(By.tagName("a"));
//		System.out.println(link.size());
//
//		List<WebElement> link1 = driver.findElements(By.xpath("//a"));
//		System.out.println(link1.size());
//
//		List<WebElement> frame = driver.findElements(By.xpath("//frame"));
//		System.out.println(frame.size());
//
//		List<WebElement> frame1 = driver.findElements(By.tagName("frame"));
//		System.out.println(frame1.size());
	}



