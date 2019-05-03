package com.carwell.pom;

import org.openqa.selenium.By;
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

public class Home implements Constants
{

	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//Click Administration
	@FindBy(xpath="//span[ text()='Administration']")
	private WebElement administration;
	
//verifyHomepageIsDisplayed
	@FindBy(xpath ="//h3[text()='Program and Non-Program']")
	private WebElement dashBoardPage;

//logout
	@FindBy(xpath ="//li[@class='dropdown user user-menu']")
	private WebElement logout;
			
//signout pop up
	@FindBy(xpath = "//a[text()='Sign out']")
	private WebElement signout;
		
//operations link
	@FindBy(xpath = "//span[text()='Operations']")
	private WebElement operations;
				
//vehicle management link
	@FindBy(xpath = "//a[@href='#/VehicleManagement']")
	private WebElement vehiclemanagement;
	
	
	@FindBy(xpath="//span[text()='Administration']/../following-sibling::ul/li[3]/a")
	private WebElement customer;
	
	@FindBy(xpath="//h3[text()='Add Customer']")
	private WebElement customerpage;
	
	public void waitForVisiblityOfCustomerPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Add Customer']")));
	}
	
	public void clickCustomer() {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(customer, 10000);
		customer.click();
	}
	
	public void clickAdministration() {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(administration, 10000);
		administration.click();
	}
		
		public void clickonUsername() {
			logout.click();
		}
		
		public void clickSigngout_Button() {
			signout.click();
		}
		
		
		public void clickOperations() {
			operations.click();
			
		}
		
// create an object and navigating to the Terminate Page
		public void navigateToVehicleManagementPage(WebDriver driver)
		{
				WebDriverWait wait=new WebDriverWait(driver,30);
				try {
					
				operations.click();
				wait.until(ExpectedConditions.visibilityOf(vehiclemanagement));
				Reporter.log("Vehicle management link is  present", true);
				vehiclemanagement.click();
				}
				catch(Exception e)
				{
					Reporter.log("Vehicle management link is not present",true);
					Generics.capturescreenshot(driver,"navigateToVehicleManagementPage");
				}
			
		}
		
		public void verifyHomepageIsDisplayed(WebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			try
			{
				wait.until(ExpectedConditions.visibilityOf(dashBoardPage));
				Reporter.log("Login successful - HomePage is displayed", true);
			}
			catch(Exception e)
			{
				Reporter.log("HomePage is not displayed", true);
				Generics.capturescreenshot(driver,"verifyHomepageIsDisplayed");
				Assert.fail();
			}
			
		}
	}

