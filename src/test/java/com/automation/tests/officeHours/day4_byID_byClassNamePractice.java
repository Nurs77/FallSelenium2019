package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day4_byID_byClassNamePractice {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        WebElement search_box = driver.findElement(By.id("search_query_top"));
        search_box.sendKeys("tshirt", Keys.ENTER);

        Thread.sleep(4000);
WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));
String errorText = error.getText();
        System.out.println("Error message: "+ errorText);

        search_box= driver.findElement(By.id("search_query_top"));
        search_box.clear();
        search_box.sendKeys("t-shirt",Keys.ENTER);

WebElement count = driver.findElement(By.className("product-count"));
        System.out.println("items found: "+ count.getText());

        WebElement addToCart = driver.findElement(By.className("ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line"));
        addToCart.click();
        WebElement addTo = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
        addTo.click();
        //ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line
        //<a class="button ajax_add_to_cart_button btn btn-default" href="http://automationpractice.com/index.php?controller=cart&amp;add=1&amp;id_product=1&amp;token=e817bb0705dd58da8db074c69f729fd8" rel="nofollow" title="Add to cart" data-id-product="1">
        //										<span>Add to cart</span>
        //									</a>
    }
}
