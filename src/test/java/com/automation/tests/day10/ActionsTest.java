package com.automation.tests.day10;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    private WebDriver driver;
    private Actions actions;


    //builder pattern => you put one method then you can take action
//builder pattern == chaining methods
//what is build?
//if you have multiple actions you have to put build
//to combine a couple of actions.
//build() is needed when you have couple of actions
//build combines the action; perform; starts the action
//in this example; first we move to one image then second so we used build
//always end with perform
//perform does not click, it starts the action, execute the event
//you can perform click, drag and drop etc
//actions class has different implementations
//moveToElement returns instance of action class that's why we can chain them



    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //pause is like Thread.sleep();

        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().
                perform();
        BrowserUtils.wait(3);

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());
BrowserUtils.wait(3);
        // move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }

    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        WebElement enabledHover = driver.findElement(By.id("ui-id-3"));
        WebElement hoverDownload = driver.findElement(By.xpath("//*[@id=\"ui-id-4\"]/span"));
        WebElement hoverPdf = driver.findElement(By.xpath("//*[@id=\"ui-id-5\"]"));

        actions.moveToElement(enabledHover).perform();
        BrowserUtils.wait(1);
        actions.moveToElement(hoverDownload).perform();
        BrowserUtils.wait(3);
        actions.moveToElement(hoverPdf).click().build().perform();
        BrowserUtils.wait(3);
    }

    @Test
    public void dragAndDropTest(){
        driver.get("http://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));
        actions.dragAndDrop(moon,earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(actual, expected);
    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        actions= new Actions(driver);
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
