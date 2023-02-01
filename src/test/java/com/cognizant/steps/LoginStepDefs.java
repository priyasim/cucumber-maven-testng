/*
 *  © [2020] Cognizant. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.cognizant.steps;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cognizant.framework.DriverManager;
import com.cognizant.pages.NewToursLogin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs extends MasterSteps {
	static Logger log = Logger.getLogger(LoginStepDefs.class);
	WebDriver driver = DriverManager.getWebDriver();
	NewToursLogin tours = PageFactory.initElements(driver, NewToursLogin.class);

	@When("^I login using the invalid username (.*) and the invalid password (.*)$")
	public void i_login_using_invalid_username_invalid_password(String userName, String password) {
		tours.login(userName, password);
	}

	@When("^I login using the valid username (.*) and the invalid password (.*)$")
	public void i_login_using_valid_username_invalid_password(String userName, String password) {
		tours.login(userName, password);
	}

	@When("^I login using the valid username (.*) and the valid password (.*)$")
	public void i_login_using_valid_username_valid_password(String userName, String password) {
		log.info("Writing to log");
		tours.login(userName, password);
	}

	

	@And("^I click on the sign in link$")
	public void i_click_on_signin_link() {
		driver.findElement(By.linkText("sign-in")).click();
	}

	@Then("^The application should stay on the login page, and not log me in")
	public void application_should_stay_on_login_page() {
		attachScreenshotForWeb();

		assertTrue(driver.getTitle().contains("Sign-on") || driver.getTitle().contains("Welcome"));
	}

	@Then("^The application should log me in and navigate to the Flight Finder page")
	public void application_should_login_navigate_to_FlightFinder_page() {
		attachScreenshotForWeb();

		assertTrue(driver.getTitle().contains("Login: Mercury Tours"), "Login Successfull");
	}
}
