package com.project.StepDefn;

import java.awt.AWTException;

import com.project.Utils.ConfigFileReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;



public class UI_Base_StepDefn extends Base_class{
	ConfigFileReader ConfigFileReader ;
	
	@Given("open the browser and launch the application")
	public void open_the_browser_and_launch_the_application() throws Throwable {
	   launch_Browser();
	   ConfigFileReader = new ConfigFileReader();
	   driver.get(ConfigFileReader.getApplicationUrl(ConfigFileReader.GetenvironmentDetails()));
	   	   
	}

	@When("Click the Login Button")
	public void click_the_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}
}
