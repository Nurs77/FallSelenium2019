package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        BrowserUtils.wait(2);
        List<WebElement> checkBox = driver.findElements(By.tagName("input")); // All checkboxes stored here
        checkBox.get(0).click();

        BrowserUtils.wait(2);
        for (int i = 0; i <checkBox.size() ; i++) { // loop throught all of them

                    // if visible                   eligible to click               not clicked yet
            if (checkBox.get(1).isDisplayed() && checkBox.get(1).isEnabled() && (!checkBox.get(1).isSelected())) {
                checkBox.get(1).click();
                System.out.println(i+1 +" checkbox is clicked");
            } else {
                System.out.println(i+1 + " checkbox wasn't clicked!");
            }
        }
        BrowserUtils.wait(2);
        driver.quit();
    }
}
