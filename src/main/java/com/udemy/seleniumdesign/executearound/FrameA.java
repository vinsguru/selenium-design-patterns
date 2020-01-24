package com.udemy.seleniumdesign.executearound;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameA {

    @FindBy(name="fn")
    private WebElement firstName;

    @FindBy(name="ln")
    private WebElement lastName;

    @FindBy(name="addr")
    private WebElement address;

    @FindBy(id="area")
    private WebElement message;

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setAddress(String address){
        this.address.sendKeys(address);
    }

    public void setMessage(String message){
        this.message.sendKeys(message);
    }

}
