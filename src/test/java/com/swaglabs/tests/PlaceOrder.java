package com.swaglabs.tests;

import com.swaglabs.pages.*;
import org.testng.annotations.Test;


public class PlaceOrder extends BaseTest{

    AbstractPage abstractPage;

    @Test
    public void placeOrder(){

        abstractPage = new AbstractPage(driver);
        abstractPage.navigateToApplication()
                 .loginToApplication("standard_user","secret_sauce")
                 .selectBackpack()
                 .clickOnCart()
                 .clickCheckoutBtn()
                 .enterUserDetails()
                 .clickOnContinue()
                 .clickOnFinish()
                 .validateMessage()
                 .clickOnMenu()
                 .clickOnLogoutBtn();

    }
}
