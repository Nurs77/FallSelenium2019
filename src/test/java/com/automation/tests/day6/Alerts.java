package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();//to click on the first button
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);
        driver.switchTo().alert().accept();

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");

        }else{
            System.out.println("TEST FAILED");
            System.out.println("expected "+ expected);
            System.out.println("actual" + actual);
        }

        BrowserUtils.wait(3);
        //####@#####################################@#####################################@#################################
        buttons.get(1).click();
        BrowserUtils.wait(2);
        driver.switchTo().alert().dismiss(); // Must be : You clicked Cancel button here
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        if(expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("expected2 "+ expected2);
            System.out.println("actual2 " + actual2);
        }
//#####@#####################################@#####################################@#################################
        buttons.get(2).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello, World!");
        alert.accept();

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";

        if(actual3.endsWith(expected3)){

            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
            System.out.println("expected3 "+ expected3);
            System.out.println("actual3 " + actual3);
        }

    }
}
