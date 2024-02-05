package com.project.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.StepDefn.Base_class;

public class Login_pojo extends Base_class{

	public Login_pojo() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "inputUsername")
	public WebElement username;
	
}
