package com.carwell.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ApplyCredits {
	
	@FindBy(xpath = "//select[@ng-model='sltCust']/..//option[.='Select any Customer']")
	private WebElement selectTerCustomer;
	Select selectCust=new Select(selectTerCustomer);
	public void selectTerCustomer(String customerName) {
		selectCust.selectByValue(customerName);
	}
	
	
	@FindBy(xpath ="//select[@ng-model='sltLoc']/..//option[.='Select any Location']")
	private WebElement selectTerLocation;
	Select selectLoc=new Select(selectTerLocation);
	public void selectLocation(String location)
	{
		selectLoc.selectByValue(location);
	}
	
	

}
