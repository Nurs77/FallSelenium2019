package com.automation.tests.day8_UnitTesting;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ForgotPasswordTask {
    private WebDriver driver;

    @Test
    public void forgotPasswordTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("email")).sendKeys("nurs__95boy@mail.ru");
        driver.findElement(By.id("form_submit")).click();
        BrowserUtils.wait(3);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void checkBoxes(){
        driver.findElement(By.linkText("Checkboxes")).click();

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);
        checkBoxes.get(0).click();
        Assert.assertTrue(checkBoxes.get(0).isSelected(),"checkbox number 1 is not selected");
        BrowserUtils.wait(2);
    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");
    }
    @AfterMethod
    public void teardown(){
        // close browser and destroy webdriver object
        driver.quit();
    }
}
