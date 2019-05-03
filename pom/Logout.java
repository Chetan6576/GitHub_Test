package com.carwell.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carwell.generics.ReadWriteExcel;

public class Logout extends ReadWriteExcel{
	
	public Logout(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='hidden-xs ng-binding']")  
	private WebElement setting;

	@FindBy(xpath="//a[@class='btn btn-default btn-flat' and text()='Sign out']")
	private WebElement logoutButton;

public void clickSetting() {
	setting.click();
}
public void clickLogout() {
	logoutButton.click();
}
}