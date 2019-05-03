package com.carwell.generics;

public interface Constants
{
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VALUE="./API/geckodriver.exe";
	
	String CHROME_KEY="webdriver.chrome.driver";
	String CHROME_VALUE="./API/chromedriver.exe";
	
	String IE_KEY = "webdriver.ie.driver";
    String IE_VALUE = ".API/IEdriverServer.exe";
    
	String DIR= System.getProperty("user.dir");
	String PATH="/Data/DataInput.xls";
	
	String XL_PATH=DIR+PATH;
	
	String SCREEN="/Screenshots//";
	String PHOTO_PATH=DIR+SCREEN;
	

}
