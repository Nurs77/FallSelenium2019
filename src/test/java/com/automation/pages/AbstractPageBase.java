package com.automation.pages;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Method for vytrack navigation. Provide tab name and module name to navigate
     * @param tabName, like Dashboards, Fleet or Customers
     * @param moduleName, like Vehicles, Vehicles Odometer and Vehicles Costs
     */
    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        //increase this wait rime if still failing
        BrowserUtils.wait(4);
    }
}
