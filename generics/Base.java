package com.carwell.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base implements Constants {

	public static WebDriver driver;

	
	@BeforeTest
	public void launchBrowser() {
		try {

			
			String browser = ReadWriteExcel.readData(XL_PATH, "ValidLogin", 1, 1);

			if (browser.equalsIgnoreCase("firefox")) {

				System.setProperty(GECKO_KEY, GECKO_VALUE);
				driver = new FirefoxDriver();
			}

			else if (browser.equalsIgnoreCase("chrome")) {

				System.setProperty(CHROME_KEY, CHROME_VALUE);
				driver = new ChromeDriver();
			}

			else if (browser.equalsIgnoreCase("IE")) {

				System.setProperty(IE_KEY, IE_VALUE);
				driver = new InternetExplorerDriver();
			}

		} catch (Exception e) {
			Reporter.log("Browser is not selected-Please enter valid browser name");
		}
		driver.manage().window().maximize();
		String url = ReadWriteExcel.readData(XL_PATH, "ValidLogin", 2, 1);
		driver.get(url);
	}

	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
