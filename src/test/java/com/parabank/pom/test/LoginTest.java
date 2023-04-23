package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.HomePage;
import com.parabank.pom.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseParaBankTest {
//    (This process is used if pages have multiple use)
//    LoginPage loginPage;
//    HomePage homePage;

    public LoginTest(){
        super();
    }

    @Test
    public void loginShouldSucceed(){
//        loginPage =new LoginPage();
//        homePage = loginPage
//                .fillUsername(getPassword())
//                .fillPassword(getPassword())
//                .clickLoginBtn();

        HomePage homePage =new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();

        Assert.assertTrue(homePage.isLogoutTextIsDisplayed());
    }
}
