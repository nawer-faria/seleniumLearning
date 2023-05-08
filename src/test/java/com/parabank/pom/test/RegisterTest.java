package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.HomePage;
import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.RegisterPage;
import com.parabank.pom.util.GeneralUtil;
import com.parabank.pom.util.ReadAndWriteProperties;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterTest extends BaseParaBankTest {

    public RegisterTest(){
        super();
    }

    @DataProvider(name = "registerTestDDT")
    public Object[][] getSignupDataFromExcel() {
        return GeneralUtil.getTestData("Sheet1");
    }

    @DataProvider(name = "registerTestDDTNotAllField")
    public Object[][] getSignupNotAllFieldDataFromExcel() {
        return GeneralUtil.getTestData("Sheet2");
    }

    @Test
    public void registerShouldSucceed(){
        //Created a variable to use same username and Password
        String username=LoremIpsum.getInstance().getTitle(1);

        HomePage homePage = new LoginPage()
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
                .clickRegisterBtn();
        Assert.assertTrue(homePage.isLogoutTextIsDisplayed());
//        ReadAndWriteProperties.writePropertyValue("username", username);
//        ReadAndWriteProperties.writePropertyValue("password",username); //As username and password are same
    }


    @Test (dataProvider = "registerTestDDT")
    public void registerWithDdtShouldSucceed(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password, String repeatedPassword) {

        HomePage homePage = new LoginPage()
                .clickRegisterLinkBtn()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillPhoneNumber(phoneNumber)
                .fillSsn(ssn)
                .fillUsername(username)
                .fillPassword(password)
                .fillRepeatedPassword(repeatedPassword)
                .clickRegisterBtn();
        Assert.assertTrue(homePage.isLogoutTextIsDisplayed());
    }

    @Test (dataProvider = "registerTestDDTNotAllField")
    public void registerWithDdtNotAllFieldShouldSucceed(String firstName, String lastName, String address, String city, String state, String zipCode, String phoneNumber, String ssn) {

        RegisterPage registerPage = new LoginPage()
                .clickRegisterLinkBtn()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillPhoneNumber(phoneNumber)
                .fillSsn(ssn)
                .clickRegister();
        Assert.assertTrue(registerPage.getErrorCount() > 0);

    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            takeScreenshot(result.getMethod().getMethodName());
        }
        driver.quit();
    }
}
