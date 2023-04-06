package vtigetautomation;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

public class ExtentReport {

	public static void main(String[] args) throws IOException {
		Date Tm = new Date();
//		long time = Tm.getTime();

//		File fileObj = new File(System.getProperty("user.dir")+"screenshot//Vtiger11.html");

		ExtentSparkReporter htmlReport = new ExtentSparkReporter("screenshot//Vtiger8888777777777777.html"); //

		ExtentReports ExtReport = new ExtentReports();
		ExtReport.attachReporter(htmlReport); //
		
		ExtReport.setSystemInfo("OS Name", System.getProperty("os.name"));
		ExtReport.setSystemInfo("UserName", System.getProperty("user.name"));										
		ExtReport.setSystemInfo("Server name", "Qa Server");
		ExtentTest extesTes = ExtReport.createTest("Tc001");

		WebDriver driver = new ChromeDriver();
 
		extesTes.log(Status.INFO, "Chrome Browser launched Succesfully");
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		extesTes.log(Status.INFO, "Username(admins) is entered successfully in username box");

		driver.findElement(By.name("user_password")).sendKeys("admin");
		extesTes.log(Status.INFO, "Password(admin) is entered successfully in Password box");

		driver.findElement(By.name("Login")).click();
		extesTes.log(Status.INFO, "Clicked Performed succesfully on Login Button");
		
		
		TakesScreenshot tScreenshot = (TakesScreenshot) driver;
		File form = tScreenshot.getScreenshotAs(OutputType.FILE);
		File to = new File("sa//vtiger.png");
//		String print = to.getAbsolutePath();
//		System.out.println(print);

		Files.copy(form, to);

//		boolean checkVisiblityOfMarketing = driver.findElement(By.xpath("//a[text()='Marketing']")).isDisplayed();
//		if (checkVisiblityOfMarketing == true) {
//			extesTes.log(Status.PASS, "Marketing button is visible TC001 is Passed");
//
//		} else {
//			extesTes.log(Status.FAIL, "Marketing button is Invisible TC001 is Failed");
//
//		}

		
//		ExtentTest extTest1 = ExtReport.createTest("Tc002");
//		extTest1.log(Status.FAIL, "zxcvbnm,./");
		
		TakesScreenshot tScreenshot1 = (TakesScreenshot) driver;
		File form1 = tScreenshot1.getScreenshotAs(OutputType.FILE);
		File to1 = new File("sa//" + Tm.toString().replace(":", "_") + ".png");
		Files.copy(form1, to1);
		extesTes.addScreenCaptureFromPath(to1.getAbsolutePath());
		ExtReport.flush();
	}
//		long time2 = Tm.getTime();
//		String print1 = to1.getAbsolutePath();
//		System.out.println(print1);
}
