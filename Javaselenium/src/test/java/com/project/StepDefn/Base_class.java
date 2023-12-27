package com.project.StepDefn;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.Utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class extends Constants{
public static WebDriver driver;
public static String variableName ="";

	public static void Launch_browser() {	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();		
	}
	public static void ClickButton(WebElement element) {
		element.click();

	}
	public static void loadurl(String url) {
		driver.get(url);

	}
	public static void sendtext(WebElement element,String text) {
		element.sendKeys(text);
		
	}
	public static String getText(WebElement element) {
		return element.getText();
		
	}
	
}
