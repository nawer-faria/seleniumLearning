package com.parabank.pom.pages;

import com.parabank.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindTransactionsPage extends BaseParaBankTest {

    @FindBy(id = "criteria.transactionId")
    WebElement findByTransactionIdEl;

    @FindBy(css = "button[ng-click*='ID']")
    WebElement findByTransactionIdBtn;

    @FindBy(id = "criteria.onDate")
    WebElement findByDateEl;

    @FindBy(css = "button[ng-click*='DATE']")
    WebElement findByDateBtn;

    @FindBy(id = "criteria.fromDate")
    WebElement findByFromDateEl;

    @FindBy(id = "criteria.toDate")
    WebElement findByToDateEl;

    @FindBy(css = "button[ng-click*='DATE_RANGE']")
    WebElement findByDateRangeBtn;

    @FindBy(id = "criteria.amount")
    WebElement findByAmountEl;

    @FindBy(css = "button[ng-click*='AMOUNT']")
    WebElement findByAmountBtn;

    public FindTransactionsPage fillTransactionId(String transactionId){
        findByTransactionIdEl.isDisplayed();
        findByTransactionIdEl.clear();
        findByTransactionIdEl.sendKeys(transactionId);
        return this;
    }

    public FindTransactionsPage clickFindByTransactionIdBtn(){
        findByTransactionIdBtn.isDisplayed();
        findByTransactionIdBtn.click();
        return this;
    }

    public FindTransactionsPage fillDate(String date){
        findByDateBtn.isDisplayed();
        findByDateBtn.clear();
        findByDateBtn.sendKeys(date);
        return this;
    }

    public FindTransactionsPage clickFindByDateBtn(){
        findByDateBtn.isDisplayed();
        findByDateBtn.click();
        return this;
    }

    public FindTransactionsPage fillFromDate(String fromDate){
        findByFromDateEl.isDisplayed();
        findByFromDateEl.clear();
        findByFromDateEl.sendKeys(fromDate);
        return this;
    }

    public FindTransactionsPage fillToDate(String toDate){
        findByToDateEl.isDisplayed();
        findByToDateEl.clear();
        findByToDateEl.sendKeys(toDate);
        return this;
    }

    public FindTransactionsPage clickFindByDateRangeBtn(){
        findByDateRangeBtn.isDisplayed();
        findByDateRangeBtn.click();
        return this;
    }

    public FindTransactionsPage fillAmount(String amount){
        findByAmountEl.isDisplayed();
        findByAmountEl.clear();
        findByAmountEl.sendKeys(amount);
        return this;
    }

    public FindTransactionsPage clickFindByAmountBtn(){
        findByAmountBtn.isDisplayed();
        findByAmountBtn.click();
        return this;
    }


}
