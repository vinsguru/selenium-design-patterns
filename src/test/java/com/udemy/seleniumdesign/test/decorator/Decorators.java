package com.udemy.seleniumdesign.test.decorator;

import com.udemy.seleniumdesign.decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDisplay(List<WebElement> elements){
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //ingredients
    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDisplay(dp.getAdminComponents());
    private static final Consumer<DashboardPage> suComponentPresent = (dp) -> shouldDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> suComponentNotPresent = (dp) -> shouldNotDisplay(dp.getSuperUserComponents());
    private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay(dp.getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent = (dp) -> shouldNotDisplay(dp.getGuestComponents());
    //role selection
    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> suSelection = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");

    //user role pages
    public static final Consumer<DashboardPage> guestPage = guestSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> suPage = suSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentNotPresent);
    public static final Consumer<DashboardPage> adminPage = adminSelection.andThen(guestComponentPresent).andThen(suComponentPresent).andThen(adminComponentPresent);


}
