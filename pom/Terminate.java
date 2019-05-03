package com.carwell.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.carwell.generics.Constants;
import com.carwell.generics.Generics;
import com.carwell.generics.ReadWriteExcel;

public class Terminate  implements Constants
{

	//initialization
	public Terminate(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	
//declaration 
	@FindBy(xpath="//a[text()='Add Records']")
	private WebElement addRecords;
	
	@FindBy(xpath = "//a[text()='Terminate']")
	private WebElement terminateTab;
	
	
//to select the customer
	@FindBy(xpath = "//div[@class='col-sm-4 col-md-offset-3']/label[text()='Customer ']/following-sibling:div")
	private WebElement selectCustomerDropdown;
			
			
	@FindBy(xpath = "//div[@class='col-sm-4 col-md-offset-3']/label[text()='Customer ']/following-sibling::div/div/div/input")
	private WebElement customerTextbox;
			 		
//to select the location
	@FindBy(xpath = "//div[@class='col-sm-4 col-md-offset-3']/label[text()='Location ']/following-sibling::div")
	private WebElement selectLocationDropdown;
				
	@FindBy(xpath = "//div[@class='col-sm-4 col-md-offset-3']/label[text()='Location ']/following-sibling::div/div/div/input")
	private WebElement locationTextbox;
					
// to select the vehicle
	@FindBy(xpath ="//div[@class='col-sm-4 col-md-offset-3']/label[text()='Vehicle List ']/following-sibling::div/a")
	private WebElement selectVehicleDropdown;
	
	
	@FindBy(xpath="//div[@class='col-sm-4 col-md-offset-3']/label[text()='Vehicle List ']//following-sibling::div/div/div/input")
	private WebElement vehicleTextbox;
	
//#To Do Select vehicle from dropdown
	@FindBy(xpath="//div[@class='col-sm-4 col-md-offset-3']/label[text()='Vehicle List ']/following-sibling::div/div/ul/li")
	private List<WebElement> vehiclelist_option_terminate;
			
//to click on checkBox
	@FindBy(xpath ="//input[@ng-model='applyCredits']")
	private WebElement applyCreditsChecbox;
				
//to select the terminate date
	@FindBy(xpath = "//input[@ng-model='TermineDate']")
	private WebElement  terminateTextbox;
				
//to click on submit button		
	@FindBy(xpath ="//button[@ng-click='onClkTerminateRecord()']")
	private WebElement submitButton;
				
//click on confirmation button
	@FindBy(xpath = "//button[@class='confirm' and text()='OK']")
	private WebElement confirmationButton;
					
//click on close button of print_popup
	@FindBy(id="btnClose1")
	private WebElement popupCloseButton;
					
//click on print button of print_popup			
	@FindBy(id="btnPrint")
	private WebElement popupPrintButton;
					
//click on save button of print_window	
	@FindBy(xpath="/button[text()='Save']")
	private WebElement saveButton;
				
//click on cancel button of print_window		
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancelButton;
				
//to click on clear button
	@FindBy(xpath ="//button[@ng-click='ClearTerminateRecord()']")
	private WebElement clear_button;
	
			
			public void clickTerminateTab() 
			{
				Generics generics = new Generics();
				generics.clickWhenReadyElement(terminateTab, 10000);
				terminateTab.click();
			}
			
			public void selectCustomer(String customerName) 
			{
				
				selectCustomerDropdown.click();
				customerTextbox.sendKeys(customerName);
				customerTextbox.sendKeys(Keys.ENTER);
				
			}
			
			public void selectLocation(String locationName){
				selectLocationDropdown.click();
				locationTextbox.sendKeys(locationName);
				locationTextbox.sendKeys(Keys.ENTER);
				
			}
			
			public void selectVehicle(String vehicleName)
			{
				selectVehicleDropdown.click();
				vehicleTextbox.sendKeys(vehicleName);	
				vehicleTextbox.sendKeys(Keys.ENTER);
			}
			
			public void clickApplyCreditsCheckbox() {
				applyCreditsChecbox.click();
			}
			
			public void enterTerminateDate(String terminateDate)  {
				terminateTextbox.sendKeys(terminateDate);
			}
			
			public void clickSubmitbutton_ToTerminate() {
				submitButton.click();
			}
			
			public void clickConfirmationButton()
			{
				Generics generics = new Generics();
				generics.clickWhenReadyElement(confirmationButton, 10000);
				confirmationButton.click();
			}
			
			public void clickCloseButton()
			{
				popupCloseButton.click();
			}
			
			public void clickPrintButton()
			{
				popupPrintButton.click();
			}
			
			public void clickSavebutton()
			{
				saveButton.click();
			}
			
			public void clickCancelbutton()
			{
				cancelButton.click();
			}
			
			public void clickClearbutton_ToClearData() {
				clear_button.click();
			}

			public void selectCustomer_Terminate(String sheetname, int rownum, int colnum) 
			{
				
				selectCustomerDropdown.click();
				String customerName = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
				customerTextbox.sendKeys(customerName);
				customerTextbox.sendKeys(Keys.ENTER);
				
			}
			
			
			public void selectLocation_Terminate(String sheetname, int rownum, int colnum){
				selectLocationDropdown.click();
				String locationName = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
				locationTextbox.sendKeys(locationName);
				locationTextbox.sendKeys(Keys.ENTER);
				
			}
			
//verifying the title
		public void verifyVehicleManagementPageisDisplyed(WebDriver driver)
					{
						WebDriverWait wait=new WebDriverWait(driver, 30);		
						try
						{	
							wait.until(ExpectedConditions.visibilityOf(terminateTab));
							Reporter.log("Vehicle Management Page is displayed", true);
						}
						catch(Exception e)
						{	
							Reporter.log("Vehicle Management page is not displayed", true);
							Generics.capturescreenshot(driver,"verifyVehicleManagementPageisDisplyed");
						}
					
					}
					public void verifyTerminatePageIsDisplayed(WebDriver driver)
					{
						WebDriverWait wait = new WebDriverWait(driver, 10);
						try
						{
							wait.until(ExpectedConditions.visibilityOf(terminateTextbox));
							Reporter.log("Terminate page is displyed", true);
						}
						catch(Exception e)
						{
							Reporter.log("Terminate page is not displyed",true);
							Generics.capturescreenshot(driver, "verifyTerminatePageIsDisplayed");
						}
					}
					
//click on confirmation button	
		public void verifyConfirmationPopupIsDisplayed(WebDriver driver)
			{
				WebDriverWait wait=new WebDriverWait(driver, 30);		
				try
				{
					wait.until(ExpectedConditions.visibilityOf(confirmationButton));
					Reporter.log("Vehicle Terminated pop up is displayed", true);
					confirmationButton.click();			
				}
				catch(Exception e)
					{
					Reporter.log("Vehicle Terminated pop up is not displayed", true);
					Generics.capturescreenshot(driver, "verifyConfirmationPopupIsDisplayed");
					}
					
				}
		
		/*public void writeVehicleList() {
			selectVehicleDropdown.click();
			List<WebElement> vehicles = vehiclelist_option_terminate;
			int count = vehicles.size();
			for (int i=1; i<count; i++) {
				String vehicle = vehicles.get(i).getText();
				ReadWriteExcel.writeData(XL_PATH, "TerminatePage", i, 3, vehicle);
				
			}
			
		}*/
		
		public void writeVehicleList(int i, int rownum) {
			String vehiclename = ReadWriteExcel.readData(XL_PATH, "VehicleManagment", rownum, 0);
				ReadWriteExcel.writeData(XL_PATH, "TerminatePage", i, 3, vehiclename);
		}		
}
