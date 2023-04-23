package com.parabank.pom.pages;

import com.parabank.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseParaBankTest {
    @FindBy(linkText = "Log Out")
    WebElement logoutText;

    @FindBy(linkText = "Open New Account")
    WebElement openNewAccountLink;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public OpenNewAccountPage clickOpenNewAccountLink(){
        openNewAccountLink.isDisplayed();
        openNewAccountLink.clear();
        return new OpenNewAccountPage();
    }

    public boolean isLogoutTextIsDisplayed(){
        return logoutText.isDisplayed();
    }
}
