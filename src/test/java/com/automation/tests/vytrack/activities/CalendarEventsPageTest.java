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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTest {
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
    private By createCalBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.id("s2id_oro_calendar_event_form_calendar");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By owner2 = By.className("select2-chosen");
    private By startDate = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTime = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");


    @Test
    public void Calls(){
    WebElement createCalBtnElement=driver.findElement(createCalBtnBy);
    Assert.assertTrue(createCalBtnElement.isDisplayed());
    }

    @Test
    public void verifyDefaultValues(){
        driver.findElement(createCalBtnBy).click();
        BrowserUtils.wait(3);
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String ownerName = driver.findElement(owner2).getText().trim();
        Assert.assertEquals(currentUserName,ownerName);

        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDate).getAttribute("value");

        Assert.assertEquals(actualDate,expectedDate);
        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTime).getAttribute("value");
        Assert.assertEquals(actualTime,expectedTime);

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
        driver.findElement(By.linkText("Calendar Events")).click();
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
