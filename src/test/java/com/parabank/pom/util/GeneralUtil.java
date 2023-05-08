package com.parabank.pom.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GeneralUtil {
    public final static int WAIT_TIME = 30;

    public static Object[][] getTestData(String sheetName) {
        // Excel file path
        String path = System.getProperty("user.dir") + "/src/test/java/com/parabank/pom/testdata/ddt.xlsx";

        // Checking excel file is available or not
        Workbook book = null;
        Sheet sheet;
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Creates a workbook in book factory
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Will get the provided sheet name from workbook
        sheet = book.getSheet(sheetName);

        // Creates 2 dimensional data object with row and column
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());

        // get row number from sheet
        for (int i = 0; i < sheet.getLastRowNum(); i++) {

            // get column number from sheet
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                System.out.println(data[i][k]);
            }
        }
        return data;
    }
}
