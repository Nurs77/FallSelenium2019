package com.automation.tests.practice;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import  java.util.*;
      //  import java.sql.*;
public class OCA {
          public static void main(String[] args) throws Exception{
              WebDriverManager.chromedriver().version("79").setup();
              WebDriver driver = new ChromeDriver();
              driver.get("https://www.google.com/");
              Thread.sleep(1000);
              driver.navigate().to("http://practice.cybertekschool.com/");
//driver.get();
              String title1 = driver.getTitle();
              Thread.sleep(3000);
              driver.quit();
          }
}