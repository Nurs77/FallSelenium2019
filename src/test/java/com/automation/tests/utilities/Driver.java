package com.automation.tests.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for everyone
    private static WebDriver driver;


    //we make ir private so no one can crete object of Driver class
    //everyone should call static getter method instead
    private Driver(){

    }
    public static WebDriver getDriver(){

        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");

            }
        }
        return driver;
    }
    public static void closeDriver(){
        if (driver!= null){
            driver.quit();
            driver = null;
        }
    }
}
