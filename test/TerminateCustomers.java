package com.carwell.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.carwell.generics.Base;
import com.carwell.generics.Generics;
import com.carwell.generics.ReadWriteExcel;
import com.carwell.pom.Home;
import com.carwell.pom.Logout;
import com.carwell.pom.TerminateCustomer;

public class TerminateCustomers extends Base {
	
	@Test(priority=10)
	public void terminateCustomer() throws InterruptedException {
		TerminateCustomer terminateCustomer = new TerminateCustomer(driver);
		Home home = new Home(driver);
		Thread.sleep(2000);
		home.clickAdministration();
		home.clickCustomer();
		terminateCustomer.terminateCustomerPage();
		int rowCount = ReadWriteExcel.getRowCount("TerminateCustomer");
		System.out.println("terCust row count is ..." + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			String custName = ReadWriteExcel.readData(XL_PATH, "TerminateCustomer", i, 0);
			String custLoc = ReadWriteExcel.readData(XL_PATH, "TerminateCustomer", i, 1);
			String CustContact = ReadWriteExcel.readData(XL_PATH, "TerminateCustomer", i, 2);
			System.out.println(custName + "..." + custLoc + ".." + CustContact);
			if (CustContact.equalsIgnoreCase("NoContact")) {
				try {
					terminateCustomer.terminateCustomerPage();
					terminateCustomer.selectCustomer(custName);
					Generics.pressEnter();
					terminateCustomer.selectLocation(custLoc);
					Generics.pressEnter();
					terminateCustomer.clickTerminate(); // click terminate
					Generics.handlePopupWithOk();
					terminateCustomer.clickOkButton();
				} catch (NoAlertPresentException | NullPointerException e) {
					System.out.println("Exception handalled");
				}
			} else {
				try {
					terminateCustomer.terminateCustomerPage();
					terminateCustomer.selectCustomer(custName);
					Generics.pressEnter();
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					terminateCustomer.selectLocation(custLoc);
					Generics.pressEnter();
					terminateCustomer.selectContact(CustContact);
					Generics.pressEnter();
					terminateCustomer.clickTerminate();
					Generics.handlePopupWithOk();
					terminateCustomer.clickOkButton();
				} catch (NoAlertPresentException | NullPointerException e) {
					System.out.println("Exception handalled");
				}
			}
		}
	}

	@Test(priority = 11)
	public static void logoutValidation() {
		Logout lo = new Logout(driver);
		lo.clickSetting();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lo.clickLogout();

	}
}
