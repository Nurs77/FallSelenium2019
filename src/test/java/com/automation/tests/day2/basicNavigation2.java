package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicNavigation2 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        driver.navigate().to("http://juventus.com");
        if(driver.getTitle().toLowerCase().contains("juventus")){
            System.out.println("test passed");
        }else{
            System.out.println("try again");
        }
      driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");
        Thread.sleep(3000);
        driver.navigate().forward();
        System.out.println("Title: "+ driver.getTitle());

        driver.close();


    }
    public static void  verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
    }
}
