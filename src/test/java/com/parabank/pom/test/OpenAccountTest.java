package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.HomePage;
import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.pages.OpenNewAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAccountTest extends BaseParaBankTest {
//    LoginPage loginPage;
//    HomePage homePage;
//    OpenNewAccountPage openNewAccountPage;

    public OpenAccountTest(){
        super();
    }

    @Test
    public void openNewAccountShouldSucceed(){
//        loginPage= new LoginPage();
//
//        homePage=loginPage
//                .fillUsername(getUsername())
//                .fillPassword(getPassword())
//                .clickLoginBtn();
//        openNewAccountPage=homePage
//                .clickOpenNewAccountLink()
//                .clickOpenNewAccountBtn();
//        Assert.assertTrue(openNewAccountPage.hasNewAccountId());

        OpenNewAccountPage openNewAccountPage =new LoginPage()
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn()
                .clickOpenNewAccountLink()
                .clickOpenNewAccountBtn();
        Assert.assertTrue(openNewAccountPage.hasNewAccountId());

    }
}
