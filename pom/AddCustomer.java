package com.carwell.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwell.generics.Generics;

public class AddCustomer {

	public AddCustomer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@ng-model='CustName']")
	private WebElement customerName;   // 

	@FindBy(xpath="//div[@class='col-sm-4']/label[text()='Customer Profile ']/following-sibling::select/following-sibling::div/a")
	private WebElement dropdown;    // profile drop-down

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement customerProfile;     // profile text-box

	@FindBy(xpath="(//input[@placeholder='Location *'])[1]")
	private WebElement location;  // loc text-box

	@FindBy(xpath="(//td[@class='text-left'])[1]/div/div/a")
	private WebElement region;  // click on 1st region drop-down

	@FindBy(xpath="(//input[@type='text'])[4]")
	private WebElement RegionTxtBox;  // region text box

	@FindBy(xpath="(//td[@class='text-left' ])[2]/div/div/a")
	private WebElement Custtax; 

	@FindBy(xpath="(//input[@type='text'])[5]")
	private WebElement taxTxtBox;  

	@FindBy(xpath="(//input[@placeholder='Contact Name'])[1]")
	private WebElement contactName;

	@FindBy(xpath="(//input[@placeholder='Address1'])[1]")
	private WebElement address1;

	@FindBy(xpath="(//input[@placeholder='City'])[1]")
	private WebElement cityName;

	@FindBy(xpath="(//input[@placeholder='State'])[1]")
	private WebElement state;

	@FindBy(xpath="(//input[@placeholder='Zip'])[1]")
	private WebElement zip;

	@FindBy(xpath="//button[@class='btn btn-info pull-right' and text()='Add']")
	private WebElement addButton;

	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;

	@FindBy(xpath="//p[@style='display: block;']")
	private WebElement txtMsg;  // pop-up text message

	@FindBy(xpath="//button[@style='margin-right:5px;' and @ng-click='addNewLOcationRow(CustomerDetails)']")
	private WebElement addRow;

	@FindBy(xpath="//button[ @ng-click='onclkClearCustData()' and text()='Clear']")
	private WebElement clear;
	
	@FindBy(xpath="//a[text()='Add']")
	private WebElement addtab;
	
	public void clickAddTab() {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(addtab, 10000);
		addtab.click();
	}

	public void clickCustName(String name) {
		customerName.clear();
		customerName.sendKeys(name);
	}
	public void clickProfile(String profile) {
		dropdown.click();
		customerProfile.clear();
		customerProfile.sendKeys(profile);
	}
	public void custLocation(String loc) {
		location.clear();
		location.sendKeys(loc);
	}
	public void custRegion(String reg) {
		region.click();
		RegionTxtBox.clear();
		RegionTxtBox.sendKeys(reg);
	}
	public void custTax(String tax) {

		Custtax.click();
		taxTxtBox.clear();
		taxTxtBox.sendKeys(tax);
	}

	public void addContact( String contact) {
		contactName.clear();
		contactName.sendKeys(contact);
	}

	public void addAddress( String address) {
		address1.clear();
		address1.sendKeys(address);
	}

	public void addcity( String city) {
		cityName.clear();
		cityName.sendKeys(city);
	}

	public void addState( String stNmae) {
		state.clear();
		state.sendKeys(stNmae);
	}
	public void addZip( String zipCod) {
		zip.clear();
		zip.sendKeys(zipCod);
	}
	public void clickAdd() {
		addButton.click();
	}

	public void clickOk()  {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(okButton, 10000);
		okButton.click();
	}

	public void addNewRow() {
		addRow.click();
	}

	public void clickClear() {
		clear.click();
	}
}



