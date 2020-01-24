package com.udemy.seleniumdesign.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver, GooglePage> ENG = (d) -> new GoogleEnglish(d);
    private static final Function<WebDriver, GooglePage> FR = (d) -> new GoogleFrench(d);
    private static final Function<WebDriver, GooglePage> SA = (d) -> new GoogleArabic(d);
    private static final Function<WebDriver, GooglePage> ES = (d) -> new GoogleES(d);
    private static final Map<String, Function<WebDriver, GooglePage>> MAP = new HashMap<>();

    static {
        MAP.put("ENG", ENG);
        MAP.put("FR", FR);
        MAP.put("SA", SA);
        MAP.put("ES", ES);
    }

    public static GooglePage get(String language, WebDriver driver){
        return MAP.get(language).apply(driver);
    }

}
