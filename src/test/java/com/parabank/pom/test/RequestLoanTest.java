package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.RequestLoanPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RequestLoanTest extends BaseParaBankTest {

    public RequestLoanTest() {
        super();
    }

    @Test
    public void requestForLoanShouldSucceed() {

        String username = LoremIpsum.getInstance().getTitle(1);

        RequestLoanPage requestLoanPage = new LoginPage()
                .clickRegisterLinkBtn()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getTitle(3))
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhoneNumber(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(username)
                .fillRepeatedPassword(username)
                .clickRegisterBtn()
                .clickRequestLoanLink()
                .fillAmount(300)
                .fillDownPayment(50)
                .clickApplyNowBtn();
        Assert.assertTrue(requestLoanPage.hasNewAccountId());

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }
}
