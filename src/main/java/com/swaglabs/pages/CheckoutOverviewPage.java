package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutOverviewPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutOverviewPage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }


    @FindBy(how= How.ID, using=("finish"))
    private WebElement finishBtn;


    public void clickOnFinish(){
        this.wait.until(ExpectedConditions.visibilityOf(finishBtn));
        this.finishBtn.click();
    }
}
