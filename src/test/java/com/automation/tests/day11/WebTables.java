package com.automation.tests.day11;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();


    }

    @Test
    public void getColumnNames() {
        //th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }
    @Test
    public void verifyRowCount() {
        ////tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get a size of this collection, it automatically equals to number of elements
        Assert.assertEquals(rows.size(), 4);
    }
    @Test
    public void getSpecificColumn(){
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }
    //first way :
//once you find email cell in the first table that has this email (jdoe@hotmail.com) then go to following sibling has linkText delete :
//td element with email and td element that contains delete => are siblings
////td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
//to make it easier :
//go back to parent and find link that has text delete
//td is child of tr
////td[text()='fbach@yahoo.com']/..//a[text()='delete']
//even more simple way :
//it is more hardcoded! but easiest => you provide index so it s not flexible, if index is change ilocator will never find it
//go to find email in the first table go to parent go to second link inside this element
////table[1]//td[text()='jsmith@gmail.com']/..//a[2]
    @Test
    public void delete(){
        driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']//following-sibling::td/a[text()='delete']")).click();
        BrowserUtils.wait(3);
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount,3);

        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());



    }
@Test
public void getColumnIndexByName(){
        String columnName="Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));
        int index = 0;
    for (int i = 0; i <columnNames.size() ; i++) {
        String actualColumnName = columnNames.get(i).getText();
        System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));
        if (actualColumnName.equals(columnName)) {
            index = i + 1;
            break;
        }
    }
    Assert.assertEquals(index, 3);
}
@Test
public void getSpecificCell(){
        String expected = "http://jsmith.com";
        int row = 1;
        int column =1;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td["+ column+ "]";

        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(),expected);

}
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
