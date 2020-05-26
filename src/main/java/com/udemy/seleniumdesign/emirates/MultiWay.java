package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class MultiWay implements FlightSearch {

    @FindBy(id = "dvRadioMulti")
    private WebElement multiwayRadio;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom1-suggest")
    private WebElement departureCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom2-suggest")
    private WebElement departureCity2;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo1-suggest")
    private WebElement arrivalCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo2-suggest")
    private WebElement arrivalCity2;

    @FindBy(id = "ctl00_c_CtWNW_txtD1")
    private WebElement departureDate;

    @FindBy(id = "ctl00_c_CtWNW_txtD2")
    private WebElement departureDate2;

    private DatePicker datePicker;

    @Override
    public void search(Map<String, String> searchDetails) {
        this.multiwayRadio.click();
        this.departureCity.sendKeys(searchDetails.get("departureCity"));
        this.arrivalCity.sendKeys(searchDetails.get("arrivalCity"));
        this.departureDate.click();
        this.datePicker.selectToday();
        this.arrivalCity2.sendKeys(searchDetails.get("arrivalCity2"));
        this.departureDate2.click();
        this.datePicker.selectRandomFutureDate();
    }

    @Override
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

}
