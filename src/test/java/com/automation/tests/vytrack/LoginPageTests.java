package com.automation.tests.vytrack;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
// STATIC IMPORT OF ALL ASSERTIONS


public class LoginPageTests {
  private WebDriver driver;
    // https is a secured version of http protocol
    //http -it'' hypertex transfer protocol that every single website is using nowadays
    //https data encrypted , no chance for hackers to retrieve info
    // http - data as a plain text, very easy to hack it
    private String username = "storemanager57";
    private String password = "UserUser123";
    private String URL = "https://qa2.vytrack.com/user/login";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy= By.cssSelector("[class='alert alert-error'] > div");

    @Test(description = "trying something")
    public void invalidUserName(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("USerUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);

    }
    @Test
    public void loginAsStore(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        String expected = "Dashboard";
        String actual = driver.getTitle();
        BrowserUtils.wait(2);
        assertEquals(actual,expected, "page title is not correct!");

    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);


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
