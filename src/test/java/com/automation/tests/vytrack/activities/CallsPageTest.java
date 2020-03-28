package com.automation.tests.vytrack.activities;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class CallsPageTest {
    private WebDriver driver;
    private Actions actions;
    // https is a secured version of http protocol
    //http -it'' hypertex transfer protocol that every single website is using nowadays
    //https data encrypted , no chance for hackers to retrieve info
    // http - data as a plain text, very easy to hack it
    private String username = "storemanager57";
    private String password = "UserUser123";
    private String URL = "https://qa2.vytrack.com/user/login";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");

    @Test
    public void Calls(){
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(4);
    driver.findElement(By.linkText("Calls")).click();
    BrowserUtils.wait(3);


    }
    @AfterMethod
    public void teardown(){
        // if webDriver object alive
        if(driver != null) {
            // close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }
    }
}
