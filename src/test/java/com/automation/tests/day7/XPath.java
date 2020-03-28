package com.automation.tests.day7;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);

       driver.findElement(By.xpath("//*[@id=\"login\"]/div[1]/div/input")).sendKeys("nursKrasava");
       driver.findElement(By.xpath("//label[text()='Password']/following-sibling::input")).sendKeys("supersecret");
driver.findElement(By.xpath("//*[@id=\"wooden_spoon\"]")).click();




        BrowserUtils.wait(3);
        driver.quit();

    }
}
