package com.parabank.pom.test;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.AccountsOverviewPage;
import com.parabank.pom.pages.LoginPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.parabank.pom.BaseParaBankTest.takeScreenshot;

public class AccountsOverviewTest extends BaseParaBankTest {

    public AccountsOverviewTest(){
        super();
    }

    @Test
    public void getAccountsOverviewShouldSucceed(){

        String username=LoremIpsum.getInstance().getTitle(1);

        AccountsOverviewPage accountsOverviewPage = new LoginPage()
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
                .clickAccountsOverviewLink();
        Assert.assertTrue(accountsOverviewPage.isAccountOverviewText());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }

}
