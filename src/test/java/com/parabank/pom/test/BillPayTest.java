package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BillPayTest extends BaseParaBankTest {

    public BillPayTest() {
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
