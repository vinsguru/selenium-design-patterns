package com.udemy.seleniumdesign.decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreenPage {

    private final WebDriver driver;

    @FindBy(id="coupon")
    private WebElement coupon;

    @FindBy(id="couponbtn")
    private WebElement couponbtn;

    @FindBy(id="cc")
    private WebElement cc;

    @FindBy(id="year")
    private WebElement year;

    @FindBy(id="cvv")
    private WebElement cvv;

    @FindBy(id="buy")
    private WebElement buy;

    @FindBy(id="status")
    private WebElement status;

    public PaymentScreenPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/java/html/java8-payment-screen.html");
    }

    public void applyPromocode(String promocode){
        this.coupon.sendKeys(promocode);
        this.couponbtn.click();
    }

    public void enterCC(String cc, String year, String cvv){
        this.cc.sendKeys(cc);
        this.year.sendKeys(year);
        this.cvv.sendKeys(cvv);
    }

    public void buyProduct(){
        this.buy.click();
    }

    public String getStatus(){
        return this.status.getText().trim();
    }

}
