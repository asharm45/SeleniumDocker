package com.swaglabs.tests;

import com.swaglabs.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class PlaceOrder extends BaseTest{

    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutInformationPage informationPage;
    CheckoutOverviewPage overviewPage;
    CheckoutCompletePage completePage;



    @Test
    public void placeOrder(){

        loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user","secret_sauce");

        productPage = new ProductPage(driver);
        productPage.selectBackpack()
                 .clickOnCart();

        cartPage = new CartPage(driver);
                 cartPage.clickCheckoutBtn();

        informationPage = new CheckoutInformationPage(driver);
                 informationPage.enterUserDetails()
                 .clickOnContinue();

        overviewPage = new CheckoutOverviewPage(driver);
                 overviewPage.clickOnFinish();

        completePage = new CheckoutCompletePage(driver);
        completePage.validateMessage()
                 .clickOnMenu()
                 .clickOnLogoutBtn();


        //click on sorting button

        List<WebElement> list = driver.findElements(By.xpath(""));

        List<String> beforeSort = list.stream().map(s->s.getText().trim()).collect(Collectors.toList());
        List<String> sortedList = beforeSort.stream().sorted().collect(Collectors.toList());

        Assert.assertTrue(beforeSort.equals(sortedList));


    }

}
