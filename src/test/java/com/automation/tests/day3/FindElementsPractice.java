package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class FindElementsPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("nursultan@gmail.com");
        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        // when you see type ="submit" you can use submit() instead of click()
        // it makes sense to use when click() method doesn't work
        signUp.click();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";

        WebElement message = driver.findElement(By.className("subheader")); // it will find what the class will display us after submiting
        String actual = message.getText();// getting the text
        System.out.println(actual);
        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }






        driver.close();
    }
}
