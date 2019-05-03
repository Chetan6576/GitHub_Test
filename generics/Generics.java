package com.carwell.generics;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Generics extends Base
{
	
	
// to take a screen shot when test case fails
	
public static void capturescreenshot(WebDriver driver,String methodName) 
{
	try 
	{
	
	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
	TakesScreenshot ts =(TakesScreenshot)driver;
	File srcfile = ts.getScreenshotAs(OutputType.FILE);
	File destfile = new File(PHOTO_PATH+methodName+"//"+methodName+"_"+timeStamp+".png");
	
    //copy file into local_drive using java code
	FileUtils.copyFile(srcfile,destfile);	
	}
	
	catch (IOException e) 
	{
		e.printStackTrace();
	}
} 

//Refresh the page
public static void refreshPage(WebDriver driver) {
	driver.navigate().refresh();
}

/*Selecting_option_from_dropdown*/
public void selectFromDropDown(List<WebElement> xpath, String option) {
	List<WebElement> elementList = xpath;

	for (WebElement element : elementList) {
		if (element.getText().equalsIgnoreCase(option)) {
			element.click();
			break;
		}
	}
}

public static void pressEnter() {

	Actions action = new Actions(driver);
	action.sendKeys(Keys.ENTER).build().perform();
}

public static void handlePopupWithOk() {
	Alert alert = driver.switchTo().alert();
	String txtMsg = alert.getText();
	Reporter.log(txtMsg, true);
	alert.accept();	
}
public static void handlePopupWithCancel() {
	Alert alert = driver.switchTo().alert();
	String txtMsg = alert.getText();
	Reporter.log(txtMsg, true);
	 alert.dismiss();

}
public static void PagescrollDown() {
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,250)", ""); // To scroll down the page
}

/*click_on_when_locator_is_clickable*/
public void clickWhenReadyElement(WebElement element, int timeout) {
	//WebElement element = null;
	WebDriverWait wait = new WebDriverWait(driver, timeout);
	element = wait.until(ExpectedConditions.elementToBeClickable(element));
	//element.click();
}
}
