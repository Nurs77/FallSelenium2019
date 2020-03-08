package com.automation.tests.day4;

import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class warmUpTask {
    static WebDriver driver;
    public static void main(String[] args) throws Exception{
        ebay();
        amazon();
       wikiperdia();

    }
    public static void ebay()throws Exception{
       driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("Java book");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(4000);
        String resultNumber = driver.findElement(By.className("sg-col-inner")).getText();
        System.out.println("ebay resultNumber = " + resultNumber);

        driver.quit();

    }

    public static void amazon() throws Exception{
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java book");
        driver.findElement(By.className("nav-input")).click();
        String title = driver.getTitle();
        Thread.sleep(4000);
driver.quit();

    }
    public static void wikiperdia() throws Exception{
       driver = DriverFactory.createDriver("chrome");
driver.get("http://en.wikipedia.org/wiki/Main_Page");
driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
driver.findElement(By.linkText("Selenium (software)")).click();
String link = driver.getCurrentUrl();
if(link.endsWith("Selenium_(software)")){
    System.out.println("Test PASSED");
}else{
    System.out.println("TEST FAILED");
}
    }


//public static DriverFactory(String browserName){
//        if(browserName.equalsIgnoreCase("chrome")){
//            WebDriverManager.chromedriver().setup();
//            return new ChromeDriver();
//        }else{
//            WebDriverManager.firefoxdriver().setup();
//            return new FirefoxDriverManager();
//        }
//
//}

    }


