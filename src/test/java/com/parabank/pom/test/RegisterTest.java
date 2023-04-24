package com.parabank.pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.HomePage;
import com.parabank.pom.pages.LoginPage;
import com.parabank.pom.util.ReadAndWriteProperties;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseParaBankTest {
    public RegisterTest(){
        super();
    }

    @Test
    public void registerShouldSucceed(){
        String username=LoremIpsum.getInstance().getTitle(1); //Using same username and Password
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
}
