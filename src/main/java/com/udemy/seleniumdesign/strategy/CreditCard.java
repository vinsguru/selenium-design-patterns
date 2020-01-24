package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CreditCard implements PaymentOption {

    @FindBy(id = "cc")
    private WebElement cc;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "cvv")
    private WebElement cvv;

    @Override
    public void enterPaymentInformation(Map<String, String> paymentDetails) {
        this.cc.sendKeys(paymentDetails.get("cc"));
        this.year.sendKeys(paymentDetails.get("year"));
        this.cvv.sendKeys(paymentDetails.get("cvv"));
    }
}
