package com.carwell.test;

import org.testng.annotations.Test;

import com.carwell.generics.Base;
import com.carwell.generics.Generics;
import com.carwell.generics.ReadWriteExcel;
import com.carwell.pom.AddCustomer;
import com.carwell.pom.Home;
import com.carwell.pom.Login;

public class AddCustomers extends Base {

@Test(priority=4)
	public void homePageValidation() throws InterruptedException {
		Home home = new Home(driver);
		Login login = new Login(driver);
		String username = ReadWriteExcel.readData(XL_PATH, "ValidLogin", 3, 1);
		String password = ReadWriteExcel.readData(XL_PATH, "ValidLogin", 4, 1);
		login.navigateToHomePage(username,password);
		home.verifyHomepageIsDisplayed(driver);
		home.navigateToVehicleManagementPage(driver);
		home.clickAdministration();
		home.clickCustomer();
		home.waitForVisiblityOfCustomerPage(driver);
	}

	@Test(priority=5)
	public void addCustomer() {
		AddCustomer addCustomer = new AddCustomer(driver);
		int rowCount = ReadWriteExcel.getRowCount("AddCustomer");
		System.out.println("For add cust ,..." + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			String name = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 0);
			String profile = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 1);
			String loc = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 2);
			String reg = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 3);
			String tax = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 4);
			String contact = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 5);
			if (contact.equalsIgnoreCase("null")) {
				try {
					ReadWriteExcel.writeData(XL_PATH, "TerminateCustomer", i, 0, name);
					ReadWriteExcel.writeData(XL_PATH, "TerminateCustomer", i, 1, loc);
					ReadWriteExcel.writeData(XL_PATH, "TerminateCustomer", i, 2, "NoContact");
					addCustomer.clickCustName(name);
					addCustomer.clickProfile(profile);
					Generics.pressEnter();
					addCustomer.custLocation(loc);
					addCustomer.custRegion(reg);
					Generics.pressEnter();
					addCustomer.custTax(tax);
					Generics.pressEnter();
					Generics.PagescrollDown();
					addCustomer.clickAdd();
					addCustomer.clickOk();
				} catch (NullPointerException e) {
					System.out.println("exception occurs");
				}
			} else {
				String address1 = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 6);
				String city = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 7);
				String state = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 8);
				String zip = ReadWriteExcel.readData(XL_PATH, "AddCustomer", i, 9);
				try {
					ReadWriteExcel.writeData(XL_PATH, "TerminateCustomer", i, 0, name);
					ReadWriteExcel.writeData(XL_PATH, "TerminateCustomer", i, 1, loc);
					ReadWriteExcel.writeData(XL_PATH, "TerminateCustomer", i, 2, contact);
					addCustomer.clickCustName(name);
					addCustomer.clickProfile(profile);
					Generics.pressEnter();
					addCustomer.custLocation(loc);
					addCustomer.custRegion(reg);
					Generics.pressEnter();
					addCustomer.custTax(tax);
					Generics.pressEnter();
					addCustomer.addContact(contact);
					addCustomer.addAddress(address1);
					addCustomer.addcity(city);
					addCustomer.addState(state);
					addCustomer.addZip(zip);
					Generics.PagescrollDown();
					addCustomer.clickAdd();
					addCustomer.clickOk();
				}	 catch (NullPointerException e) {
					System.out.println("exception occurs");
				}
			}
		}
	}
}