package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage navigateToApplication(){
        driver.get("https://www.saucedemo.com/");
        return new LoginPage(driver);
    }
}
