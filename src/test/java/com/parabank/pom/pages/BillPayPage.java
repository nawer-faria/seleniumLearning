package com.parabank.pom.pages;

import com.parabank.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BillPayPage extends BaseParaBankTest {
    @FindBy(name = "payee.name")
    WebElement payeeNameEl;

    @FindBy(name = "payee.address.street")
    WebElement payeeAddressEl;

    @FindBy(name = "payee.address.city")
    WebElement payeeCityEl;

    @FindBy(name = "payee.address.state")
    WebElement payeeStateEl;

    @FindBy(name = "payee.address.zipCode")
    WebElement payeeZipCodeEl;

    @FindBy(name = "payee.phoneNumber")
    WebElement payeePhoneNumberEl;

    @FindBy(name = "payee.accountNumber")
    WebElement payeeAccountNumberEl;

    @FindBy(name = "verifyAccount")
    WebElement verifyAccountEl;

    @FindBy(name = "amount")
    WebElement amountEl;

    @FindBy(css = "input.button")
    WebElement sendPaymentBtn;

    @FindBy(css = "span.error")
    List<WebElement> errors;

    public BillPayPage() {
        PageFactory.initElements(driver, this);
    }

    public BillPayPage fillPayeeName(String payeeName){
        payeeNameEl.isDisplayed();
        payeeNameEl.clear();
        payeeNameEl.sendKeys(payeeName);
        return this;
    }

    public BillPayPage fillPayeeAddress(String payeeAddress){
        payeeAddressEl.isDisplayed();
        payeeAddressEl.clear();
        payeeAddressEl.sendKeys(payeeAddress);
        return this;
    }

    public BillPayPage fillPayeeCity(String payeeCity){
        payeeCityEl.isDisplayed();
        payeeCityEl.clear();
        payeeCityEl.sendKeys(payeeCity);
        return this;
    }

    public BillPayPage fillPayeeState(String payeeState){
        payeeStateEl.isDisplayed();
        payeeStateEl.clear();
        payeeStateEl.sendKeys(payeeState);
        return this;
    }

    public BillPayPage fillPayeeZipCode(String payeeZipCode){
        payeeZipCodeEl.isDisplayed();
        payeeZipCodeEl.clear();
        payeeZipCodeEl.sendKeys(payeeZipCode);
        return this;
    }

    public BillPayPage fillPayeePhoneNumber(String payeePhoneNumber){
        payeePhoneNumberEl.isDisplayed();
        payeePhoneNumberEl.clear();
        payeePhoneNumberEl.sendKeys(payeePhoneNumber);
        return this;
    }

    public BillPayPage fillPayeeAccountNumber(String payeeAccountNumber){
        payeePhoneNumberEl.isDisplayed();
        payeePhoneNumberEl.clear();
        payeePhoneNumberEl.sendKeys(payeeAccountNumber);
        return this;
    }

    public BillPayPage fillVerifyAccount(String verifyAccount){
        verifyAccountEl.isDisplayed();
        verifyAccountEl.clear();
        verifyAccountEl.sendKeys(verifyAccount);
        return this;
    }

    public BillPayPage fillAmount(int amount){
     amountEl.isDisplayed();
     amountEl.clear();
     amountEl.sendKeys(String.valueOf(amount));
     return this;
    }

    public BillPayPage clickSendPaymentBtn(){
        sendPaymentBtn.isDisplayed();
        sendPaymentBtn.click();
        return this;
    }

    public int getErrorCount() {
        return errors.size();
    }
}
