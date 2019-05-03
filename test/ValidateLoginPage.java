package com.carwell.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.carwell.generics.Base;
import com.carwell.generics.ReadWriteExcel;
import com.carwell.pom.Home;
import com.carwell.pom.Login;

public class ValidateLoginPage extends Base {


	@Test(priority = 1)
	//validate Login button, with blank userName and password fields
	public void blank_Credentials()
	{		
		Login loginPage = new Login(driver);
		loginPage.loginPageIsDisplayed(driver);
		loginPage.clickLogin();
		loginPage.verifyErrorMsgIsDisplayed(driver);
	}

	@Test(priority = 2)
	//validate Login button, with invalid login_credentials(userName and password)
	public void inValid_Credentials()
	{
		Login loginPage = new Login(driver);
		 
		int rowCount = ReadWriteExcel.getRowCount("InValidCredentials");
		
		//total number of rows present in excel Sheet
		String rowCountNum=String.valueOf(rowCount);
		Reporter.log("Total number of rows present : " + rowCountNum);
		
		for (int i = 1; i<=rowCount; i++)
		{
				try {
			// get's Login credentials from excel
			String un = ReadWriteExcel.readData(XL_PATH, "InValidCredentials", i, 1);
			String pwd = ReadWriteExcel.readData(XL_PATH, "InValidCredentials", i, 2);

		
				if(un.equalsIgnoreCase("null")) {
					// Enter password in respective fields of application
					loginPage.enterPassword(pwd);
					loginPage.clickLogin();
					
					//calls verifyErrorMsgIsDisplayed method
					loginPage.verifyErrorMsgIsDisplayed(driver);
				}
				else if(pwd.equalsIgnoreCase("null")) {
					// Enter password in respective fields of application
					loginPage.enterUserName(un);
					loginPage.clickLogin();
					
					//calls verifyErrorMsgIsDisplayed method
					loginPage.verifyErrorMsgIsDisplayed(driver);
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	}

	@Test(priority = 3)
	//validate Login button, with valid login_credentials(userName and password)
	public void valid_Credentials()
	{
		Login loginPage = new Login(driver);
		
		//Get's Login credentials from excel
		String un = ReadWriteExcel.readData(XL_PATH,"ValidLogin", 3, 1);
		String pwd = ReadWriteExcel.readData(XL_PATH, "ValidLogin", 4, 1);

		// Enter userName and password in respective fields of application
		loginPage.enterUserName(un);
		loginPage.enterPassword(pwd);
		loginPage.clickLogin();
	
		Home homePage = new Home(driver);
		
		
		//calls the verifyTitle method and validate for expected title and actual title
		homePage.verifyHomepageIsDisplayed(driver);
		
		//Logout from the application
		homePage.clickonUsername();
		homePage.clickSigngout_Button();		
		loginPage.loginPageIsDisplayed(driver); //validate login page is displayed, after logout
		
		
	}

}
