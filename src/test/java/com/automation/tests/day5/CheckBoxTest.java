package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxTest {
    public static void main(String[] args) {

        // VERIFY THAT 1st CHECKBOX IS NOT SELECTED

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
if(!checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected()){
    System.out.println("TEST PASSED");

}else {
    System.out.println("TEST FAILED");
}
        BrowserUtils.wait(2);

WebElement checkbox1 = checkBoxes.get(0);
checkbox1.click();

if(checkbox1.isSelected()){
    System.out.println("TEST PASSED");
    System.out.println("checkbox #1 is selected");
}else {
    System.out.println("TEST FAILED");
    System.out.println("checkbox #1 is not selected");
}


    }
}
