package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtils;
import com.google.j2objc.annotations.Weak;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByMultipleOptions {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languageSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languageSelect.isMultiple();
        System.out.println(isMultiple);

        languageSelect.selectByVisibleText("Java");
        languageSelect.selectByVisibleText("JavaScript");
        languageSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguages = languageSelect.getAllSelectedOptions();
        for (WebElement selectedLanguage: selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }


    }
}