package com.carwell.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.carwell.generics.Constants;
import com.carwell.generics.Generics;

public class Login implements Constants {


	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
//userName textbox
	@FindBy(id = "login-username")
	private WebElement userNameTextbox;
	
//password textbox	
	@FindBy(id = "login-password")
	private WebElement passwordTextbox;
	
//login button
	@FindBy(id = "login")
	private WebElement loginButton;
		
//error message
	@FindBy(xpath ="//p[@style='display: block;']")
	private WebElement errorMessage;
	
//to click on OK button when error message is displayed
	@FindBy(xpath = "//button[@class='confirm']")
	private WebElement okButton;
	
//click on forgot password link
	@FindBy(xpath = "//input[@value='Forgot Password?']")
	private WebElement forget_password_link;
	
//carWell Logo
	@FindBy(xpath = "//h1[.='Carwell']")
	private WebElement carwellLogo;
	
	public void enterUserName(String un) {
			userNameTextbox.clear();
			userNameTextbox.sendKeys(un);
		}
	
	public void enterPassword(String pwd) {
		passwordTextbox.clear();
		passwordTextbox.sendKeys(pwd);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	
	public void clickOK() {
		okButton.click();
	}
		
	public void clickForgotPassword() {
		forget_password_link.click();
	}
	
	
	public void verifyErrorMsgIsDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(errorMessage));
			String message=errorMessage.getText();
			Reporter.log("Unable to login-Error message displayed is : " + message, true);
			okButton.click();
		}
		catch (Exception e) {
			Reporter.log("Error message is not displayed", true);
			Generics.capturescreenshot(driver, "verifyErrorMsgIsDisplayed");
		}
	}
	
	public void loginPageIsDisplayed(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(carwellLogo));
			Reporter.log("CarWell Login page is displayed", true);
		}
		catch (Exception e) {
			Reporter.log("CarWell Login page is not displayed", true);
			Generics.capturescreenshot(driver, "loginPageIsDisplayed");
			Assert.fail();
		}
	}

//navigating to the HomePage
	public void navigateToHomePage(String un, String pwd)
		{
			userNameTextbox.clear();
			userNameTextbox.sendKeys(un);
			passwordTextbox.clear();
			passwordTextbox.sendKeys(pwd);
			loginButton.click();
		}
}
