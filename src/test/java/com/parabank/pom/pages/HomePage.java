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

    @FindBy(linkText = "Accounts Overview")
    WebElement accountsOverviewLink;

    @FindBy(linkText = "Transfer Funds")
    WebElement transferFundsLink;

    @FindBy(linkText = "Bill Pay")
    WebElement billPayLink;

    @FindBy(linkText = "Find Transactions")
    WebElement findTransactionsLink;

    @FindBy(linkText = "Update Contact Info")
    WebElement updateContactInfoLink;

    @FindBy(linkText = "Request Loan")
    WebElement requestLoanLink;

    @FindBy(linkText = "Log Out")
    WebElement logoutLink;


    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public boolean isLogoutTextIsDisplayed(){
        return logoutText.isDisplayed();
    }

    public OpenNewAccountPage clickOpenNewAccountLink(){
        openNewAccountLink.isDisplayed();
        openNewAccountLink.click();
        return new OpenNewAccountPage();
    }

    public AccountsOverviewPage clickAccountsOverviewLink(){
        accountsOverviewLink.isDisplayed();
        accountsOverviewLink.click();
        return new AccountsOverviewPage();
    }

    public TransferFundsPage clickTransferFundsLink(){
        transferFundsLink.isDisplayed();
        transferFundsLink.click();
        return new TransferFundsPage();
    }

    public BillPayPage clickBillPayLink(){
        billPayLink.isDisplayed();
        billPayLink.click();
        return new BillPayPage();
    }

    public FindTransactionsPage clickFundTransferLink(){
        findTransactionsLink.isDisplayed();
        findTransactionsLink.click();
        return new FindTransactionsPage();
    }

    public UpdateContactPage clickUpdateContactInfoLink(){
        updateContactInfoLink.isDisplayed();
        updateContactInfoLink.click();
        return new UpdateContactPage();
    }

    public RequestLoanPage clickRequestLoanLink(){
        requestLoanLink.isDisplayed();
        requestLoanLink.click();
        return new RequestLoanPage();
    }

    public LoginPage clickLogoutLink(){
        logoutLink.isDisplayed();
        logoutLink.click();
        return new LoginPage();
    }
}
