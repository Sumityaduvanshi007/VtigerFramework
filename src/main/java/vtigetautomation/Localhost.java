package vtigetautomation;

import java.awt.Dimension;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Localhost {

	public static void main(String[] args) throws InterruptedException   {
		// System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		WebDriver driver =null;
		try {
			driver=new ChromeDriver();
			driver.get("http:localhost:8888");
			WebElement webname = driver.findElement(By.name("user_name"));
			webname.clear();
			webname.sendKeys("admin");
			
		} catch (NoSuchElementException e) {
			driver=new ChromeDriver();
			driver.get("http:localhost:8888");
			WebElement webname = driver.findElement(By.name("user_name"));
			webname.clear();
			webname.sendKeys("admin");
			System.out.println("Please check the code");
			
		}catch (NoSuchWindowException n) {
			driver=new ChromeDriver();
			driver.get("http:localhost:8888");
			WebElement webname = driver.findElement(By.name("user_name"));
			webname.clear();
			webname.sendKeys("admin");
			System.out.println("Please check the code");
		}

	
		WebElement webpass = driver.findElement(By.name("user_password"));
		webpass.clear();
		webpass.sendKeys("admin");
		
		WebElement webd = driver.findElement(By.xpath("//select[@name='login_theme']"));
		Select sel=new Select(webd); 
		List<WebElement> ge=sel.getOptions();
		for (int i = 0; i < ge.size(); i++) {
		WebElement text = ge.get(i);
		}
		String	print=webd.getText();
		System.out.println(print);
		sel.selectByIndex(1);
		Thread.sleep(3000);
	    sel.selectByValue("woodspice");
	    Thread.sleep(3000);
		sel.selectByVisibleText("bluelagoon");
	    sel.getFirstSelectedOption();
	    
		org.openqa.selenium.Dimension login = driver.findElement(By.name("Login")).getSize();
		int ht = login.getHeight();
		int wt = login.getWidth();
		System.out.println(ht + "," + wt);
		if (ht==40 & wt==138) {
			System.out.println("home page open");
		} else {
			System.out.println("home page not open");
		}
//		driver.findElement(By.name("Login")).click();
		
//		driver.get("http://localhost:8888/");
//		WebElement webname = driver.findElement(By.name("user_name"));
//		webname.clear();
//		webname.sendKeys("admin");
//
//		WebElement webpass = driver.findElement(By.name("user_password"));
//		webpass.clear();
//		webpass.sendKeys("admin");
//
//		driver.findElement(By.name("Login")).click();
//
////	WebElement screeshot=driver.findElement(By.xpath("//a[text()='Marketing']"));
////	screeshot.click();
////	screeshot.sendKeys(Keys.CONTROL.SHIFT.);
//		Date time = new Date();
//	long Time=time.getTime();
//		TakesScreenshot tScreenshot = (TakesScreenshot) driver;
//		File form = tScreenshot.getScreenshotAs(OutputType.FILE);
//		File to = new File("screeshot//"+Time+".png");
//		String print = to.getAbsolutePath();
//		System.out.println(print);
//
//		Files.copy(form, to);

	}

}
