package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");

        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir" )+"/pom.xml";
        System.out.println(filePath);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(4);
        driver.quit();

    }
}
