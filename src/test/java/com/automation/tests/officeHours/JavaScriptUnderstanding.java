package com.automation.tests.officeHours;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;

public class JavaScriptUnderstanding {
    @Test
    public void test1(){
        // Driver Instance Creator
        WebDriver driver = DriverFactory.createDriver("chrome");
        // Navigating to etsy homepage
        driver.get("http://etsy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('global-enhancements-search-query').value='send these characters'");
    }
    
    @Test(description = "get the page title")
    public void test2(){
        WebDriver driver = DriverFactory.createDriver("chrome");
        // Navigating to etsy homepage
        driver.get("http://etsy.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String getTitle= js.executeScript("return document.title").toString();
        System.out.println("getTitle = " + getTitle);
    }
}
