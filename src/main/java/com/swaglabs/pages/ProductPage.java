package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends AbstractPage{

    private WebDriverWait wait;

    public ProductPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.ID, using=("add-to-cart-sauce-labs-backpack"))
    private WebElement backpack;

    @FindBy(how= How.ID, using=("shopping_cart_container"))
    private WebElement cart;

    public ProductPage selectBackpack(){
        this.wait.until(ExpectedConditions.visibilityOf(backpack));
        this.backpack.click();
        return this;
    }

    public CartPage clickOnCart(){
        this.wait.until(ExpectedConditions.visibilityOf(cart));
        this.cart.click();
        return new CartPage(driver);
    }
}
