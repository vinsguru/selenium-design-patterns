package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class OneWay implements FlightSearch {

    @FindBy(id = "dvRadioOneway")
    private WebElement onewayRadio;

    @FindBy(id = "ctl00_c_CtWNW_ddlFrom-suggest")
    private WebElement departureCity;

    @FindBy(id = "ctl00_c_CtWNW_ddlTo-suggest")
    private WebElement arrivalCity;

    @FindBy(id = "ctl00_c_CtWNW_dvDepartDate")
    private WebElement departureDate;

    private DatePicker datePicker;

    @Override
    public void search(Map<String, String> searchDetails) {
        this.onewayRadio.click();
        this.departureCity.sendKeys(searchDetails.get("departureCity"));
        this.arrivalCity.sendKeys(searchDetails.get("arrivalCity"));
        this.departureDate.click();
        this.datePicker.selectToday();
    }

    @Override
    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

}
