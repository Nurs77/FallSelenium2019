package com.automation.tests.vytrack.fleet;

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
import static org.testng.Assert.*;
import java.util.List;

public class VehiclesTests {
    private WebDriver driver;
    private String username = "storemanager57";
    private String password = "UserUser123";
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
        private By fleetBy=By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
private By subtitleBy = By.className("oro-subtitle");
private By pageNumber = By.cssSelector("input[type='number']");


    @Test
    public void verifyPageSubTitle(){

WebElement subTitle = driver.findElement(subtitleBy);

String excpected ="All Cars";

 String actual = subTitle.getText();
 Assert.assertEquals(actual,excpected);







       // assertEquals(actual,expected);
        BrowserUtils.wait(2);
    }

    @Test
    public void pohuiMespi(){


        String expected = "1";
            String actual = driver.findElement(pageNumber).getAttribute("value");
            Assert.assertEquals(actual,expected);


    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
//       driver.findElement(fleetBy).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(4);

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
