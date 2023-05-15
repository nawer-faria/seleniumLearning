package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.UpdateContactPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class UpdateContactTest extends BaseParaBankTest {

    public UpdateContactTest() {
        super();
    }

    @Test
    public void updateContactInfoShouldSucceed() {

        UpdateContactPage updateContactPage = new LoginPage()
                .fillUsername("Demo User")
                .fillPassword("abc")
                .clickLoginBtn()
                .clickUpdateContactInfoLink()
                .fillFirstName("Faria")
                .fillLastName("Nawer")
                .fillAddress("67")
                .fillCity("Dhaka")
                .fillState("Dhaka")
                .fillZipCode("10002")
                .fillPhoneNumber("778-62-8144")
                .clickUpdateProfileBtn();

        Assert.assertTrue(updateContactPage.isProfileUpdatedText());
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }
}
