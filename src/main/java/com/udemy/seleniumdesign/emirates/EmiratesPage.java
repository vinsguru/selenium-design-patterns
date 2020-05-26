package com.udemy.seleniumdesign.emirates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class EmiratesPage {

    private final WebDriver driver;
    private FlightSearch flightSearch;
    private final By seassionExpired = By.className("ts-session-expire--link");

    public EmiratesPage(final WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.flightSearch = PageFactory.initElements(driver, TwoWay.class);
    }

    public void goTo(){
        this.driver.get("https://fly10.emirates.com/CAB/IBE/SearchAvailability.aspx");
        this.driver.findElements(seassionExpired)
                .stream()
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public void setFlightSearch(FlightSearch flightSearch){
        this.flightSearch = flightSearch;
    }

    public void searchForFlights(Map<String, String> searchDetails){
        this.flightSearch.search(searchDetails);
    }

}
