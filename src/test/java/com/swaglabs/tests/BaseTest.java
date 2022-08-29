package com.swaglabs.tests;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeTest
    public void setup(ITestContext ctx) throws MalformedURLException {

        //Browser -> chrome / firefox
        //Host -> localhost / or host ip 10.1.1.1

        //Default value
        String host = "localhost";
        MutableCapabilities mc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("chrome")){
            mc = new ChromeOptions();
        }else{
            mc = new FirefoxOptions();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        mc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), mc);
    }
}
