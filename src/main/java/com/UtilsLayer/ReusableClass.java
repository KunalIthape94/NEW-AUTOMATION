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
	public static Excelreader excl;
	public static String testData;

	public Object getProperty(String propertyKey) {
		this.property = prop.getProperty(propertyKey);
		return property;
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

	/*
	 * public Object[][] getData() throws Exception { excl = new Excelreader(
	 * "C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\OrangeHRMNewSite\\src\\test\\resources\\TestData.xlsx"
	 * ); int row = excl.getRowCount(0)+1; int cell=excl.getCellcount(0); Object []
	 * [] fbg=new Object [row] [cell]; fbg. return null;
	 * 
	 * }
	 */
	public String getTestData(String columnName) throws Exception {
		excl = new Excelreader(
				"C:\\Users\\Kunal\\eclipes-workspace\\eclipse-workspace\\OrangeHRMNewSite\\src\\test\\resources\\TestData.xlsx");
		int row = excl.getRowCount(0) + 1;
		int cell = excl.getCellcount(0);
		Object[][] fbg = new Object[row][cell];
		int k = 0;
		for (int i = 0; i < row; i++) {
			testData = excl.getCellData(columnName, i);
		}

		return testData;

	}
}
