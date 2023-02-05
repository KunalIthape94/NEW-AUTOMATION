package com.UtilsLayer;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;

public class Demo {private FileInputStream fis;
private FileOutputStream fileOut;
private Workbook wb;
private Sheet sh;
private Cell cell;
private Row row;
private CellStyle cellstyle;
private Color mycolor;
private String excelFilePath;
private Map<String, Integer> columns = new HashMap<>();

public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
    try {
        File f = new File(ExcelPath);

        if (!f.exists()) {
            f.createNewFile();
            System.out.println("File doesn't exist, so created!");
        }

        fis = new FileInputStream(ExcelPath);
        wb = WorkbookFactory.create(fis);
        sh = wb.getSheet(SheetName);
        //sh = wb.getSheetAt(0); //0 - index of 1st sheet
        if (sh == null) {
            sh = wb.createSheet(SheetName);
        }

        this.excelFilePath = ExcelPath;

        //adding all the column header names to the map 'columns'
        sh.getRow(0).forEach(cell ->{
            columns.put(cell.getStringCellValue(), cell.getColumnIndex());
        });

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}