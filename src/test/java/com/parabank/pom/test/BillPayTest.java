package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.BillPayPage;
import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.UpdateContactPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BillPayTest extends BaseParaBankTest {

    public BillPayTest() {
        super();
    }

    @Test
    public void billPayShouldSucceed(){

        String accountNumber=LoremIpsum.getInstance().getZipCode();

        BillPayPage billPayPage = new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickBillPayLink()
                .fillPayeeName(LoremIpsum.getInstance().getNameMale())
                .fillPayeeAddress(LoremIpsum.getInstance().getTitle(3))
                .fillPayeeCity(LoremIpsum.getInstance().getCity())
                .fillPayeeState(LoremIpsum.getInstance().getStateAbbr())
                .fillPayeeZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPayeePhoneNumber(LoremIpsum.getInstance().getPhone())
                .fillPayeeAccountNumber(accountNumber)
                .fillVerifyAccount(accountNumber)
                .fillAmount(20000)
                .clickSendPaymentBtn();


    }

    @Test
    public void billPayNotAllInputFieldShouldSucceed() {
        BillPayPage billPayPage = new LoginPage()
                .fillUsername("Demo User")
                .fillPassword("abc")
                .clickLoginBtn()
                .clickBillPayLink()
                .fillPayeeName(LoremIpsum.getInstance().getNameMale())
                .fillPayeeAddress(LoremIpsum.getInstance().getTitle(3))
                .clickSendPaymentBtn();

        Assert.assertTrue(billPayPage.getErrorCount()>0);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }
}
