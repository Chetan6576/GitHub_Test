package com.carwell.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeRecordVehicleManagment {

	@FindBy(xpath="(//select[@ng-model='ChangeRecord.iVehMatrId'])[1]")
	private WebElement selectvehiclelist;
	
	public ChangeRecordVehicleManagment(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement SelectVehicleList()
	{
		return selectvehiclelist;
		
	}
}
