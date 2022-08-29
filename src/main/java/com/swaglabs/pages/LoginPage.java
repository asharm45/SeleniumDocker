package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends AbstractPage{

    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.ID, using=("user-name"))
    private WebElement uname;

    @FindBy(how= How.ID, using=("password"))
    private WebElement pwd;

    @FindBy(how= How.ID, using=("login-button"))
    private WebElement loginBtn;

    public ProductPage loginToApplication(String username, String password){
        this.wait.until(ExpectedConditions.visibilityOf(loginBtn));
        this.uname.sendKeys(username);
        this.pwd.sendKeys(password);
        this.loginBtn.click();
        return new ProductPage(driver);
    }
}
