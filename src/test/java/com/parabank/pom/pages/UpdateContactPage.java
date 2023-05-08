package com.parabank.pom.pages;

import com.parabank.pom.BaseParaBankTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactPage extends BaseParaBankTest {
    @FindBy(id = "customer.firstName")
    WebElement firstNameEl;

    @FindBy(id = "customer.lastName")
    WebElement lastNameEl;

    @FindBy(id = "customer.address.street")
    WebElement addressEl;

    @FindBy(id = "customer.address.city")
    WebElement cityEl;

    @FindBy(id = "customer.address.state")
    WebElement stateEl;

    @FindBy(id = "customer.address.zipCode")
    WebElement zipCodeEl;

    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumberEl;

    @FindBy(css = "input.button")
    WebElement updateProfileBtn;

    @FindBy(className = "title")
    WebElement updatedProfileText;

    public UpdateContactPage(){
        PageFactory.initElements(driver, this);
    }

    public UpdateContactPage fillFirstName(String firstName){
        firstNameEl.isDisplayed();
        firstNameEl.clear();
        firstNameEl.sendKeys(firstName);
        return this;
    }

    public UpdateContactPage fillLastName(String lastName){
        lastNameEl.isDisplayed();
        lastNameEl.clear();
        lastNameEl.sendKeys(lastName);
        return this;
    }

    public UpdateContactPage fillAddress(String address){
        addressEl.isDisplayed();
        addressEl.clear();
        addressEl.sendKeys(address);
        return this;
    }
    public UpdateContactPage fillCity(String city) {
        cityEl.isDisplayed();
        cityEl.clear();
        cityEl.sendKeys(city);
        return this;
    }

    public UpdateContactPage fillState(String state) {
        stateEl.isDisplayed();
        stateEl.clear();
        stateEl.sendKeys(state);
        return this;
    }

    public UpdateContactPage fillZipCode(String zipCode) {
        zipCodeEl.isDisplayed();
        zipCodeEl.clear();
        zipCodeEl.sendKeys(zipCode);
        return this;
    }

    public UpdateContactPage fillPhoneNumber(String phoneNumber) {
        phoneNumberEl.isDisplayed();
        phoneNumberEl.clear();
        phoneNumberEl.sendKeys(phoneNumber);
        return this;
    }

    public UpdateContactPage clickUpdateProfileBtn(){
        updateProfileBtn.isDisplayed();
        updateProfileBtn.click();
        return this;
    }

    public boolean isProfileUpdatedText(){
        return updatedProfileText.isDisplayed();
    }
}
