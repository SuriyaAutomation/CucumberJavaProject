package com.project.StepDefn;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.Utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class extends Constants{
public static WebDriver driver;

	public static void Launch_browser() {	
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
}
