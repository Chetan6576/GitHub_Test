package com.carwell.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwell.generics.Generics;

public class TerminateCustomer {

	public TerminateCustomer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[ text() ='Terminate']")
	private WebElement terminate;

	@FindBy(xpath="(//div[@class='col-sm-5 col-md-offset-3'])[1]/label[text()='Customer']/following-sibling::div/a")
	private WebElement nameDropdown;   // select customer drop-down

	@FindBy(xpath="(//div[@class='col-sm-5 col-md-offset-3'])[1]/label[text()='Customer']/following-sibling::div/div/div/input")
	private WebElement custmoreTxtBox;

	@FindBy(xpath="//label[text()='Location']/following-sibling::div")
	private WebElement locationDropdown;

	@FindBy(xpath="(//div[@class='col-sm-5 col-md-offset-3'])[2]/label[text()='Location']/following-sibling::div/div/div/input")
	private WebElement locationTxtBox;

	@FindBy(xpath="//label[text()='Contacts']/following-sibling::div")
	private WebElement contactDropdown;

	@FindBy(xpath="(//div[@class='col-sm-5 col-md-offset-3'])[3]/label[text()='Contacts']/following-sibling::div/div/div/input")
	private WebElement contactTxtBox ;

	@FindBy(xpath="//button[@ng-click='onClickTerminateCustomer()' ]")
	private WebElement terminateCustomer;


	@FindBy(xpath="//button[text()='OK']")
	private WebElement okButton;

	@FindBy(xpath="//p[@style='display: block;']")
	private WebElement textMsg;

	@FindBy(xpath="//button[@ng-click='ClearCustomer()' and text()='Clear']")
	private WebElement clearButton;

	public void terminateCustomerPage() {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(terminate, 10000);
		terminate.click();
	}
	public void selectCustomer(String name) {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(nameDropdown, 10000);
		nameDropdown.click();
		custmoreTxtBox.clear();
		custmoreTxtBox.sendKeys(name);
	}
	public void selectLocation(String loc) {
		locationDropdown.click();
		locationTxtBox.clear();
		locationTxtBox.sendKeys(loc);
	}
	public void selectContact(String cont) {
		contactDropdown.click();
		contactTxtBox.clear();
		contactTxtBox.sendKeys(cont);
	}
	public void clickTerminate() {
		terminateCustomer.click();
	}

	public void clickOkButton() {
		Generics generics = new Generics();
		generics.clickWhenReadyElement(okButton, 10000);
		String txt =	textMsg.getText();
		System.out.println(">>>>Confirmation msg is -: " +txt);
		okButton.click();   
	}

	public void clickClear() {
		clearButton.click();
	}



}




