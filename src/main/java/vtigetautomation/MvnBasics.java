package vtigetautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MvnBasics {
public static void main(String[] args) {
WebDriver driver= new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.switchTo().newWindow(WindowType.TAB);
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("");
}
}
