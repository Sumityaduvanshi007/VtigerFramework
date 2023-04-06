package vtigetautomation;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.evs.vtiger.generic.WebUtil;

public class TaskByRoshan {
	public static MyUtil wu;
	public static void main(String[] args) {
		wu = new MyUtil();
		ExtentReports ext = wu.genaretReports("Tc001");
		wu.launchBrowser(new ChromeDriver(),"http://localhost:8888");
		Tc001();
		Tc002();
		ext.flush();
	}
	public static void Tc001() {
	//MyUtil wu = new MyUtil();
	wu.launchBrowser(new ChromeDriver(),"http://localhost:8888");
	ExtentReports ext = wu.genaretReports("Tc001");
	wu.getTheSizeOfElement("user_name", "name", "UserBox");
	wu.getTheSizeOfElement("user_password", "name", "PasswordBox");
	wu.getTheSizeOfElement("Login", "name", "LoginButton");
	ext.flush();
}
public static void Tc002()  {
	//WebUtil wu = new WebUtil();
 	ExtentReports ext = wu.genaretReports("Tc002");
	wu.getTheLocationOfElement("user_name", "name", "UserBox");
	wu.getTheLocationOfElement("user_password", "name", "PasswordBox");
	wu.getTheLocationOfElement("Login", "name", "LoginButton");
	ext.flush();
}
public static void Tc003() {

}
}
