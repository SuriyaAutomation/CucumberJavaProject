package com.project.StepDefn;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_class {
public static WebDriver driver;

	public static void Launch_browser() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.youtube.com/");

	}
	public static void main(String[] args) {
		Launch_browser();
	}
}
