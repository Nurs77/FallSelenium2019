package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);

        List<WebElement> radioButtons = driver.findElements(By.tagName("input")); // putting all the input button's in the List so that we can loop throught them
        for (WebElement radioButton: radioButtons) {

            String id = radioButton.getAttribute("id");

            boolean isSelected = radioButton.isSelected();

            System.out.println(id+  " is selected? "+ isSelected);


            if (radioButton.isEnabled()) { // Checks if the button can be clicked or no
                radioButton.click();
                BrowserUtils.wait(1);
                System.out.println("Clicked on :: "+ id);
            }else {
                System.out.println("Button disabled, not clicked :: " + id);
            }
            System.out.println();
        }
        driver.quit();
    }
}
