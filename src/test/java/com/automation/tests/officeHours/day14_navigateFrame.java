package com.automation.tests.officeHours;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class day14_navigateFrame {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");




    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame("frame-top");
        List<WebElement> frameList = driver.findElements(By.xpath("//frame"));
        /*
            we have stored all frames webelements inside the list
            1. Loop through list
            2. swithch to each frame
                a. get test from body
                b. switch to parent
         */
        for (WebElement each : frameList) {
//            driver.navigate().refresh();
            BrowserUtils.wait(2);
            driver.switchTo().frame(each);

            String bodyText = driver.findElement(By.tagName("body")).getText();
            System.out.println("bodyText = " + bodyText);
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("bodyText = " + bodyText);

    }
    }
