package com.parabank.pom.test;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.BillPayPage;
import com.parabank.pom.pages.FindTransactionsPage;
import com.parabank.pom.pages.LoginPage;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FindTransactionsTest extends BaseParaBankTest {
    public FindTransactionsTest(){
        super();
    }

    @Test
    public void findTransactionByIdShouldSucceed(){

        FindTransactionsPage findTransactionsPage = new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickFindTransactionsLink()
                .fillTransactionId(LoremIpsum.getInstance().getPhone())
                .clickFindByTransactionIdBtn();

    }


    @Test
    public void findTransactionByDateShouldSucceed(){

        FindTransactionsPage findTransactionsPage = new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickFindTransactionsLink()
                .fillDate("05-20-2022")
                .clickFindByDateBtn();
    }


    @Test
    public void findTransactionByDateRangeShouldSucceed(){

        FindTransactionsPage findTransactionsPage = new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickFindTransactionsLink()
                .fillFromDate("05-20-2022")
                .fillToDate("10-20-2022")
                .clickFindByDateRangeBtn();
    }


    @Test
    public void findTransactionByAmountShouldSucceed(){

        FindTransactionsPage findTransactionsPage = new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickFindTransactionsLink()
                .fillAmount(3000)
                .clickFindByAmountBtn();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }
}
