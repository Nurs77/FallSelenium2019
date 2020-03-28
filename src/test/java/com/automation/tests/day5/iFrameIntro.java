package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iFrameIntro {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");

        // before looking for that element we need to jump to that frame
        // you can specify: name, id, index or webElement of the frame
        //it is like we are jumping to another layer
        driver.switchTo().frame("mce_0_ifr");

        // now, this content will be visible

        WebElement textBox = driver.findElement(By.id("tinymce"));
        System.out.println(textBox.getText());
textBox.clear();
        BrowserUtils.wait(3);
        textBox.sendKeys("Hello World");
        BrowserUtils.wait(2);

        // driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

        BrowserUtils.wait(3);
        driver.quit();


       // textBox.click();



    }
}
