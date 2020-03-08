package com.automation.tests.day3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById
{
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(4000);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        System.out.println(actual);
        if(expected.equals(actual)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        // let's click on LogOut button. it looks like a button, but it'' actually link
        // every element with <a> tag is a link
        WebElement logout = driver.findElement(By.linkText("Logout"));
        // if you have a couple spaces in the text, just use partialLinkText instead of linkText
        // linkText - equals()
        // partialLinkText - contains() - complete match doesn't required
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");
        System.out.println("href = " + href);
        System.out.println(className);
        logout.click();
        Thread.sleep(3000);

        //let's enter invalid credentials
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));

        System.out.println(errorMessage.getText());

        Thread.sleep(3000);
        System.out.println("nursultan");
        System.out.println();
    }
}
