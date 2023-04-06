package vtigetautomation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class EvsPracticesDocuments {

	public static void main(String[] args) throws InterruptedException {
		TestCase2_i();
	}

	public static void TestCase1_i() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
		driver.close();
	}

	public static void TestCase1_ii() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
		String getTheTitle = driver.getTitle();
		System.out.println(getTheTitle);
		String getTheurl = driver.getCurrentUrl();
		System.out.println(getTheurl);
		driver.close();
	}

	public static void TestCase1_iii() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().window().maximize();
		String getTheTitle = driver.getTitle();
		if (getTheTitle.equalsIgnoreCase("Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy IN")) {
			System.out.println("My Test Case is pass");
		} else {
			System.out.println("My Test Case is fail");
		}

		String getTheurl = driver.getCurrentUrl();
		if (getTheurl.equalsIgnoreCase("https://www.godaddy.com/en-in")) {
			System.out.println("My TestCase2 is pass");
		} else {
			System.out.println("My TestCase2 is fail");
		}
		String gethtml = driver.getPageSource();
		System.out.println(gethtml);
		Thread.sleep(10);
		if (gethtml.equalsIgnoreCase(getTheTitle)) {

			System.out.println("My TestCase3 is pass");
		} else {
			System.out.println("My TestCase3 is fail");
		}
		driver.close();
	}
	public static void TestCase2_i() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.godaddy.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		Actions as=new Actions(driver);
		WebElement domainClick=driver.findElement(By.xpath("//button[@id='id-d6f9deab-d554-45df-a52c-8a9ab53948b5']"));
		as.moveToElement(domainClick).click().build().perform();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement domainNameSearch= driver.findElement(By.xpath("//a[@id=\"id-3a34578f-40f3-4d2f-aaa4-0a1320f3fe6a\"]"));
		as.moveToElement(domainNameSearch).click().build().perform();
		
		WebElement domainNameClick= driver.findElement(By.xpath("//div[@class='c1doczga']"));
		as.contextClick(domainNameClick).build().perform();
	}
}
