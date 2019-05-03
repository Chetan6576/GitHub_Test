package com.carwell.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.carwell.generics.Base;
import com.carwell.generics.Generics;
import com.carwell.generics.ReadWriteExcel;
import com.carwell.pom.Home;
import com.carwell.pom.Terminate;
import com.carwell.pom.VehicleManagment;

public class TerminateVehicle extends Base{
	
	@Test(priority=6)
	public void addVehicleRecords() throws InterruptedException  {
		VehicleManagment vehicleManagement = new VehicleManagment(driver);
		Terminate terminate = new Terminate(driver);
		Home home = new Home(driver);
		home.clickAdministration();
		home.navigateToVehicleManagementPage(driver);
		
		vehicleManagement.clickAddRecordsTab(driver);

		for(int i=1; i<=ReadWriteExcel.getRowCount("VehicleManagment"); i++) {			
			vehicleManagement.selectCustomer(driver,"AddCustomer", i, 0);
			Thread.sleep(2000);
			vehicleManagement.selectLocation(driver,"AddCustomer", i, 2);
			vehicleManagement.enterVehicleNumber("VehicleManagment", i, 0);
			terminate.writeVehicleList(i, i);
			vehicleManagement.enterLiscenceNumber("VehicleManagment", i, 1);
			vehicleManagement.enterVin("VehicleManagment", i, 2);
			vehicleManagement.selectDealerCode("VehicleManagment", i, 3);
			vehicleManagement.selectProgramYear("VehicleManagment", i, 4);			
			vehicleManagement.selectVehicleType("VehicleManagment", i, 5);
			
			String date = ReadWriteExcel.readData(XL_PATH, "VehicleManagment", i, 6);		
			if(date==null || date.isEmpty()) {
				vehicleManagement.submitButton();
				Generics.capturescreenshot(driver, "addVehicleRecords");
				vehicleManagement.clickOk();
			}
			else {
				vehicleManagement.enterDate(date);
				vehicleManagement.submitButton();
				Generics.capturescreenshot(driver, "addVehicleRecords");
				vehicleManagement.clickOk();
				Thread.sleep(1000);
			}
		}	
	}

	@Test(priority = 8)
	public void clearButton_Validation() throws InterruptedException 
	{	Thread.sleep(1000);	
		Terminate terminatePage=new Terminate(driver);
		terminatePage.clickTerminateTab();
		Thread.sleep(2000);
		terminatePage.verifyTerminatePageIsDisplayed(driver);
	
		String customer = ReadWriteExcel.readData(XL_PATH, "AddCustomer", 1, 0);
		String vehLocation = ReadWriteExcel.readData(XL_PATH, "AddCustomer", 1, 2);
		String vehicleList = ReadWriteExcel.readData(XL_PATH, "TerminatePage", 1, 3);
		String terminateDt = ReadWriteExcel.readData(XL_PATH, "TerminatePage", 1, 5);
		
		terminatePage.selectCustomer(customer);
		Thread.sleep(1000);
		terminatePage.selectLocation(vehLocation);
		Thread.sleep(1000);
		terminatePage.selectVehicle(vehicleList);
		Thread.sleep(1000);
		terminatePage.clickApplyCreditsCheckbox();
		Thread.sleep(1000);
		terminatePage.enterTerminateDate(terminateDt);  //should handle calendar pop up for now we are sending date from excel sheet
		Thread.sleep(1000);
		terminatePage.clickClearbutton_ToClearData();
		//Generics.capturescreenshot(driver,"clearButton_Validation");
	 }
 
	
	@Test(priority = 9)
	public void terminateVehicle() throws InterruptedException 
	{		
		Terminate terminatePage=new Terminate(driver);
		terminatePage.verifyTerminatePageIsDisplayed(driver);
		int rowCount = ReadWriteExcel.getRowCount("TerminatePage");
		String rowNumber= String.valueOf(rowCount);
		Reporter.log(rowNumber,true);
		for (int i = 1; i<=rowCount; i++)
		{
		String customer = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 0);
		String vehLocation = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 2);
		String vehicleList = ReadWriteExcel.readData(XL_PATH, "TerminatePage", i, 3);
		String applyCredits = ReadWriteExcel.readData(XL_PATH, "TerminatePage", i, 4);
		String terminateDt = ReadWriteExcel.readData(XL_PATH, "TerminatePage", i, 5);
		
		terminatePage.verifyTerminatePageIsDisplayed(driver);
		Thread.sleep(1000);
		terminatePage.clickTerminateTab();
		Thread.sleep(1000);
		terminatePage.selectCustomer(customer);
		Thread.sleep(1000);
		terminatePage.selectLocation(vehLocation);
		Thread.sleep(1000);
		terminatePage.selectVehicle(vehicleList);
		Thread.sleep(1000);
		if(applyCredits.equalsIgnoreCase("YES"))
		{
			terminatePage.clickApplyCreditsCheckbox();
			terminatePage.enterTerminateDate(terminateDt); 	//should handle calendar pop up for now we are sending date from excel
			terminatePage.clickSubmitbutton_ToTerminate();
			terminatePage.clickConfirmationButton(); 		//pop up handling
		    //handle apply credits screen 
		}
		else
		{
			terminatePage.enterTerminateDate(terminateDt);  //should handle calendar pop up for now we are sending date from excel sheet
			terminatePage.clickSubmitbutton_ToTerminate();
			terminatePage.verifyConfirmationPopupIsDisplayed(driver);	 //pop up handling
			terminatePage.clickCloseButton();
			terminatePage.verifyTerminatePageIsDisplayed(driver);
			/*terminatePage.clickPrintbutton();
			terminatePage.clickSavebutton();*/
		}	
//		Generics.refreshPage(driver);
		
	 }
	}
}
	

