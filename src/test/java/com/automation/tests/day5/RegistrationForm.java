package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtils.wait(4);
        driver.findElement(By.name("firstname")).sendKeys("Nursultan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("Nsmith");
        driver.findElement(By.name("email")).sendKeys("nsmith@gmail.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        driver.findElement(By.name("phone")).sendKeys("571-342-2222");
        List<WebElement> genders = driver.findElements(By.name("gender"));
        //select gender
        genders.get(1).click(); //select male, for example
        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");
        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(4);
        driver.findElement(By.id("wooden_spoon")).click();


        BrowserUtils.wait(4);

        driver.quit();
    }
}
