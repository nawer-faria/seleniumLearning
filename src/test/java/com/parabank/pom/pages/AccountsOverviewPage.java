package com.parabank.pom.pages;

import com.parabank.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage extends BaseParaBankTest {

    @FindBy(className = "title")
    WebElement accountOverviewText;

    public AccountsOverviewPage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isAccountOverviewText(){
        return accountOverviewText.isDisplayed();
    }
}
