package com.carwell.pom;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.carwell.generics.Constants;
import com.carwell.generics.ReadWriteExcel;

	public class VehicleManagment implements Constants{
		@FindBy(xpath = "//a[text()='Change Record']")
		private WebElement changerecord;

		@FindBy(xpath = "//div[@class='col-sm-4']/label[text()='Customer  ']/following-sibling::div/a")
		private WebElement selectcustomer;
		
		//Clicking location dropdown
		@FindBy(xpath="//div[@class='col-sm-4']/label[text()='Location  ']/following-sibling::select/following-sibling::div")
		private WebElement locationdropdown;
		
		@FindBy(xpath="//div[@class='col-sm-4']/label[text()='Location  ']/following-sibling::div/div/div/input")
		private WebElement locationtextbox;

		@FindBy(xpath = "//div[@class='col-sm-4']/label[text()='Customer  ']/following-sibling::div/div/div/input[@type='text']")
		private WebElement customertextbox;

		@FindBy(xpath = " //table/tbody/tr[1]/td/input[@ng-model='Record.strVehNum']")
		private WebElement vehicle;

		@FindBy(xpath = "//table/tbody/tr[1]/td/input[@ng-model='Record.strBdyLicPlate']")
		private WebElement licenceplate;

		@FindBy(xpath = "//table/tbody/tr[1]/td/input[@ng-model='Record.strVin']")
		private WebElement vin;

		@FindBy(xpath = "//table/tbody/tr[1]/td/select[@ng-model='Record.strDealerCode']/following-sibling::div")
		private WebElement dealercodedropdown;

		@FindBy(xpath = "//table/tbody/tr[1]/td/select[@ng-model='Record.strDealerCode']/following-sibling::div/div/div/input[@type='text']")
		private WebElement dealercodetextbox;

		@FindBy(xpath = " //table/tbody/tr[1]/td/select[@ng-model='Record.iProgYer']/following-sibling::div")
		private WebElement programyear;

		@FindBy(xpath = "//table/tbody/tr[1]/td/select[@ng-model='Record.iProgYer']/following-sibling::div/div/div/input[@type='text']")
		private WebElement programyeartextbox;

		@FindBy(xpath = "//table/tbody/tr[1]/td/select[@ng-model='Record.iVehCode']/following-sibling::div")
		private WebElement vehicletype;

		@FindBy(xpath = "//table/tbody/tr[1]/td/select[@ng-model='Record.iVehCode']/following-sibling::div/div/div/input[@type='text']")
		private WebElement vehicletypetextbox;

		@FindBy(xpath = "//button[@ng-click='onClkRecordInsert(AddRecordDetails)']")
		private WebElement submit;

		@FindBy(xpath = "//button[@class='confirm']")
		private WebElement ok;

		@FindBy(xpath = "//button[@ng-click='onClkClearStatus()']")
		private WebElement clear;

		@FindBy(id="datepicker0")
		private WebElement datetextbox;
		
		//Click on vehicle list dropdown in terminate
		@FindBy(xpath="//div[@class='col-sm-4 col-md-offset-3']/label[text()='Vehicle List ']/following-sibling::div/a")
		private WebElement vehiclelistdropdown_terminate;
		
		//Select vehicle from dropdown
		@FindBy(xpath="//div[@class='col-sm-4 col-md-offset-3']/label[text()='Vehicle List ']/following-sibling::div/div/ul/li")
		private List<WebElement> vehiclelist_option_terminate;
		
		//Click on Add Records tab
		@FindBy(xpath="//a[.='Add Records']")
		private WebElement addrecordstab;

		public VehicleManagment(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		//Click Add Records tab
		public void clickAddRecordsTab(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(addrecordstab));
			addrecordstab.click();
		}
		
		//Click location
		public void clickVehicleList() {
			vehiclelistdropdown_terminate.click();
		}
		
		public void enterDate(String date) {
			datetextbox.click();
			datetextbox.clear();
			datetextbox.sendKeys(date);
		}

		public void changeRecord() {
			changerecord.click();
		}

		public void selectCustomer(WebDriver driver,String sheetname, int rownum, int colnum) {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(selectcustomer));
			selectcustomer.click();
			customertextbox.clear();
			String customer = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			customertextbox.sendKeys(customer);
			customertextbox.sendKeys(Keys.ENTER);
		}
		
		public void selectLocation(WebDriver driver,String sheetname, int rownum, int colnum) {
		
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(locationdropdown));
		
			locationdropdown.click();
			locationtextbox.clear();
			String location = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, rownum);
			locationtextbox.sendKeys(location);
			locationtextbox.sendKeys(Keys.ENTER);
		}

		public void enterVehicleNumber(String sheetname, int rownum, int colnum) {
			vehicle.click();
			vehicle.clear();
			String vehiclename = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			vehicle.sendKeys(vehiclename);

		}

		public void enterLiscenceNumber(String sheetname, int rownum, int colnum) {
			licenceplate.click();
			licenceplate.clear();
			String licencenum = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			licenceplate.sendKeys(licencenum);
		}

		public void enterVin(String sheetname, int rownum, int colnum) {
			vin.click();
			vin.clear();
			String vinnum = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			vin.sendKeys(vinnum);
		}

		public void selectDealerCode(String sheetname, int rownum, int colnum) {
			dealercodedropdown.click();
			dealercodetextbox.clear();
			String dealercode = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			dealercodetextbox.sendKeys(dealercode);
			dealercodetextbox.sendKeys(Keys.ENTER);
		}

		public void selectProgramYear(String sheetname, int rownum, int colnum) {
			programyear.click();
			programyeartextbox.click();
			programyeartextbox.clear();
			String progyear = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			programyeartextbox.sendKeys(progyear);
			programyeartextbox.sendKeys(Keys.ENTER);
		}

		public void selectVehicleType(String sheetname, int rownum, int colnum) {
			vehicletype.click();
			vehicletypetextbox.click();
			vehicletypetextbox.clear();
			String vehicletypes = ReadWriteExcel.readData(XL_PATH, sheetname, rownum, colnum);
			vehicletypetextbox.sendKeys(vehicletypes);
			vehicletypetextbox.sendKeys(Keys.ENTER);
		}

		public void submitButton() {
			submit.click();
		}

		public void clickOk() {
			ok.click();
		}

		public void clearButton() {
			clear.click();
		}
	}

