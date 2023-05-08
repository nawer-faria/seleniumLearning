package com.parabank.pom.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ddt {
    @Test(dataProvider = "getDataFromExcel")
    public void testExcelData(String username, String password) {
        System.out.println("\n"+username + "  " + password);

    }

    @DataProvider
    public Object[][] getDataFromExcel() {
        return GeneralUtil.getTestData("Sheet1");
    }
}
