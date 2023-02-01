package com.cognizant.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.cognizant.framework.DriverManager;
import com.cognizant.steps.LoginStepDefs;
import com.cognizant.steps.MasterSteps;

public class NewToursLogin extends MasterSteps {
	
	//1st Section

		WebDriver driver;	
		
		//2nd Paramatrized constructor
		public NewToursLogin(WebDriver driver) {
			this.driver = driver;
		}
		
		//3rd Section: Locators
		@FindBy(how = How.NAME,using = "userName") 
		private WebElement txtbx_username;

		@FindBy(how = How.NAME,using = "password") 
		private WebElement txtbx_password;
		
		@FindBy(how = How.NAME,using = "submit") 
		private WebElement btn_login;
		
	public void login(String userName, String password) {
		txtbx_username.sendKeys(userName);
		txtbx_password.sendKeys(password);

		attachScreenshotForWeb();

		btn_login.click();
	}

}
