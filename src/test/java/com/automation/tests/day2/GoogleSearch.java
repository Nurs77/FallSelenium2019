package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("q"));
        // once we found an element
        // to enter text, use sendKeys() method
        // ho wo press Enter after entering the text?
        // use Key.ENTER
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(3000);
        driver.quit();

    }
}
