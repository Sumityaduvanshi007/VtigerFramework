package com.evs.vtiger.generic;

import java.io.IOException;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.evs.vtiger.pages.login.LoginPage;
                                               
public class Practice {
	private static  WebUtil wu;
	@FindBy(name="user_name")
	private static  WebElement  user;
	@FindBy(name="user_password")
	private static  WebElement  pass;
	@FindBy(name="Login")
	private static  WebElement  login;
	public Practice(WebUtil wu) {
      this .wu=wu;
	}
	public static void main(String[] args) throws IOException  	 {
	loginScript();
//		Tc001();
//		Tc002();
	}

	public static void loginScript()  {
	
		ExtentReports ext = wu.genaretReports("Tc001");
		wu.openBrowser("chrome");
		wu.navigateUrl("http://localhost:8888/");
		wu.inputTextValue("admin", user, "UserBox");
		wu.inputTextValue("admin", pass,"PasswordBox");
		wu.click(login, "LoginButton");
		ext.flush();
	}

//	public static void Tc001()  {
//
//		ExtentReports ext = wu.genaretReports("Tc001");
//		wu.openBrowser("chrome");
//		wu.navigateUrl("http://localhost:8888/");
//		wu.getTheSizeOfElement("user_name", "name", "PasswordBox");
//		wu.getTheSizeOfElement("user_password", "name", "PasswordBox");
//		wu.getTheSizeOfElement("Login", "name", "LoginButton");
//		ext.flush();`
//	}
//
//	public static void Tc002()  {
//		
//	 	ExtentReports ext = wu.genaretReports("Tc002");
//		
//		wu.getTheLocationOfElement("user_name", "name", "PasswordBox");
//		wu.getTheLocationOfElement("user_password", "name", "PasswordBox");
//		wu.getTheLocationOfElement("Login", "name", "LoginButton");
//		ext.flush();
//	}
//
//	public static void Tc003() {
//		
//		ExtentReports ext = wu.genaretReports("Tc001");
//		wu.openBrowser("chrome");
////		LoginPage lgn= new LoginPage();
////		wu.click("//a[text()='Marketing']", "xpath", "Marketing");
//		ext.flush();
//	}
//	private void name() {
//	wu.	
//	}
	
	
}
