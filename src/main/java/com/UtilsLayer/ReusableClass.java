package com.UtilsLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.BaseLayer.ApplicationLaunchPage;

public class ReusableClass extends ApplicationLaunchPage {
	public static Properties prop;
	public static FileInputStream fis;
	private Object property;
	public Object getProperty(String propertyKey) {
		this.property =  prop.getProperty(propertyKey);
		return  property;
	}
	public void setProperty(String key, String value) {
		
		this.property = prop.setProperty(key, value);
	}
	public void propertiesReader() {
		prop = new Properties();
		try {
			fis = new FileInputStream(
					"C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\OrangeHRMNewSite\\src\\test\\resources\\Env.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
