package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutCompletePage(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }


    @FindBy(how= How.CLASS_NAME, using=("complete-header"))
    private WebElement message;

    @FindBy(how= How.ID, using=("react-burger-menu-btn"))
    private WebElement menu;

    @FindBy(how= How.XPATH, using=("//nav[@class='bm-item-list']/a[3]"))
    private WebElement logoutBtn;

    public CheckoutCompletePage validateMessage(){
        this.wait.until(ExpectedConditions.visibilityOf(message));
        if(this.message.getText().equals("THANK YOU FOR YOUR ORDER")){
            System.out.println("ORDER PLACED!!!");
        }
        return this;
    }

    public CheckoutCompletePage clickOnMenu(){
        this.wait.until(ExpectedConditions.visibilityOf(menu));
        this.menu.click();
        return this;
    }

    public void clickOnLogoutBtn(){
        this.wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        this.logoutBtn.click();
    }
}
