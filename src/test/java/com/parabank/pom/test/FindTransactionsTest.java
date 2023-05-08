package com.parabank.pom.test;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.parabank.pom.BaseParaBankTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class FindTransactionsTest extends BaseParaBankTest {
    public FindTransactionsTest(){
        super();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }
}
