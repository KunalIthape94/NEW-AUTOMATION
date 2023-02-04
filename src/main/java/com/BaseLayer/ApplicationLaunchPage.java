package com.BaseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.UtilsLayer.ReusableClass;


public class ApplicationLaunchPage {
	
	public static WebDriver driver;
	public static ReusableClass res;
	/**
	 * @author Kunal
	 * 
	 */
	public static void browserInit() {
		res=new ReusableClass();
		res.propertiesReader();
		String appURL= (String) res.getProperty("App_URL");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver = new ChromeDriver();
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	
	
	
}
