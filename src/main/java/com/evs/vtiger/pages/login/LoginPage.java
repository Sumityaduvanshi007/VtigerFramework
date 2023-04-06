package com.evs.vtiger.pages.login;

import org.openqa.selenium.WebElement;

import com.evs.vtiger.generic.WebUtil;
import com.evs.vtiger.pages.homepage.home.HomePage;

public class LoginPage {
private WebUtil objWebUtil;
private WebElement username; 
private WebElement userpassword ; 
private WebElement   Login;

private WebElement username1; 
private WebElement userpassword1; 
private WebElement   Login1;
	public LoginPage(WebUtil objWebUtil) {
		// TODO Auto-generated constructor stub
		this.objWebUtil = objWebUtil;
		
		
	}

	public HomePage validLogin() {
		objWebUtil.navigateUrl("http://localhost:8888/");
		objWebUtil.inputTextValue("admin", username ,"UserBox");
		objWebUtil.inputTextValue("admin", userpassword,  "PasswordBox");
		objWebUtil.click(Login,  "LoginButton");
		return new HomePage(objWebUtil);

	}

	public void inValidLogin() {

		objWebUtil.navigateUrl("http://localhost:8888/");
		objWebUtil.inputTextValue("admi", username1 ,"UserBox");
		objWebUtil.inputTextValue("admin", userpassword1, "PasswordBox");
		objWebUtil.click(Login1, "LoginButton");
	}

//	public void selectLanguage() {
//		objWebUtil.getWebElement(null, null, null);
//		objWebUtil.selectByVisibleText(null, null, null);
//	}
//
//	public void selectColour() {
//		objWebUtil.selectByVisibleText(null, null, null);
//	}
}
