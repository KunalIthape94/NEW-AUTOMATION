package com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreader {
	private static File f;
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static String data;
	private static XSSFSheet sheet;
	private static int rowcount;
	private Cell cell;
	private Map<String, Integer> columns = new HashMap<>();
	public Excelreader(String path) throws Exception {
		f = new File(path);
		fis = new FileInputStream(f);
		try {
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			// adding all the column header names to the map 'columns'
			sheet.getRow(0).forEach(cell -> {
							columns.put(cell.getStringCellValue(), cell.getColumnIndex());
						});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getTestData(int sheetIndex, int row, int col) {
	sheet = workbook.getSheetAt(sheetIndex);
		data = sheet.getRow(row).getCell(col).getStringCellValue();

		return data;

	}
	public int getRowCount(int sheetIndex) {
		rowcount=workbook.getSheetAt(sheetIndex).getLastRowNum();
		return rowcount;
		
	}
	public int getCellcount(int sheetIndex) {
		int cellCount=workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
		return cellCount;
		
	}
	public String getStringCellValue(int rownum, int colnum) {
		cell = sheet.getRow(rownum).getCell(colnum);
		String CellData = null;
		int i=cell.getCellType();
		if (i!=0) {
		CellData=cell.getStringCellValue();
		}
		return CellData;
		
	}
	
	
}
