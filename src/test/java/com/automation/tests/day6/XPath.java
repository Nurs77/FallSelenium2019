package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
        WebElement btn1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));

        btn1.click();

        WebElement result = driver.findElement(By.id("result"));

        System.out.println(result.getText());

        WebElement btn2 = driver.findElement(By.xpath("//button[text()='Button 2']"));
        btn2.click();
        System.out.println(result.getText());

        BrowserUtils.wait(3);

        WebElement btn3 = driver.findElement(By.xpath("//button[starts-with(@id, 'button_']"));
        btn3.click();
        System.out.println(result.getText());

        WebElement btn4 = driver.findElement(By.xpath("//button[contains(@id, '_button'][1]"));
        btn4.click();
        System.out.println(result.getText());


        BrowserUtils.wait(3);
        driver.quit();


    }
}
