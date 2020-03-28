package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestRadioButton {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
        WebElement black = driver.findElement(By.id("black"));


        if(black.isDisplayed()&& black.isEnabled()){
            System.out.println("Clicked on Black button");
            black.click();
        }else{
            System.out.println("Failed to click on Black button");
        }

        BrowserUtils.wait(2);

        if(black.isSelected()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILLED");
        }
        BrowserUtils.wait(2);
        driver.quit();
    }
}
