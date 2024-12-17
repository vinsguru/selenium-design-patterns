package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Images")
    private WebElement images;

    @FindBy(linkText = "News")
    private WebElement news;

    @FindBy(id = "hdtb-tls")
    private WebElement tools;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToImages(){
        this.images.click();
    }

    public void goToNews(){
        this.news.click();
    }

    public void clickOnTools(){
        this.tools.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.bar.isDisplayed());
    }
}
