package com.udemy.seleniumdesign.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformation userInformation;
    private Order order;
    private PaymentOption paymentOption;

    public PaymentScreen(final WebDriver driver){
        this.driver = driver;
        this.userInformation = PageFactory.initElements(driver, UserInformation.class);
        this.order = PageFactory.initElements(driver, Order.class);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public Order getOrder() {
        return order;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails){
        this.paymentOption.enterPaymentInformation(paymentDetails);
    }
}
