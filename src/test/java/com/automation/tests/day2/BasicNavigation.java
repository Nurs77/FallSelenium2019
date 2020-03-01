package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception{
        // to start selenium script we need:
        // setup  webdriver(browser driver) and create webdriver
        // object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // In selenium, everything starts from WebDriver interface
        driver.get("http://google.com");// to open a website
        String title = driver.getTitle();
        String exprectedTitle ="Google";
        System.out.println("expectedTitle = " + exprectedTitle);
        System.out.println("title = " + title);
        if(exprectedTitle.equals(title)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
        Thread.sleep(3000);
        driver.close(); // to close the browser


    }
}
