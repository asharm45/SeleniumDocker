package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInformationPage extends AbstractPage{

    private WebDriverWait wait;

    public CheckoutInformationPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.ID, using=("first-name"))
    private WebElement firstNameTextBox;

    @FindBy(how= How.ID, using=("last-name"))
    private WebElement lastNameTextBox;

    @FindBy(how= How.ID, using=("postal-code"))
    private WebElement postalTextBox;

    @FindBy(how= How.ID, using=("continue"))
    private WebElement continueBtn;


    public CheckoutInformationPage enterUserDetails(){
        this.wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
       this.firstNameTextBox.sendKeys("Amit");
       this.lastNameTextBox.sendKeys("Sharma");
       this.postalTextBox.sendKeys("123456");
       return this;
    }

    public CheckoutOverviewPage clickOnContinue(){
        this.wait.until(ExpectedConditions.visibilityOf(continueBtn));
        this.continueBtn.click();
        return new CheckoutOverviewPage(driver);
    }
}
