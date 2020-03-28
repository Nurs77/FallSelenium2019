package com.automation.tests.officeHours;

import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class da11_xpath {
    public static void main(String[] args) throws Exception {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        Thread.sleep(2000);
        //click on contacts
        //create contact
        //Use map to store information and use it later to enter in UI
        //   //tag[@attribute = 'value']
        WebElement contacts_link = driver.findElement(By.xpath("//span[.='Contacts']/following-sibling::a"));
        Thread.sleep(5000);
        contacts_link.click();
        Thread.sleep(5000);
        WebElement create_contact = driver.findElement(By.linkText("Create Contact"));
        create_contact.click();
        Thread.sleep(3000);
        String currentTitle = driver.getTitle();
        if (currentTitle.equalsIgnoreCase("Create Contact - Contacts - Customers")){
            System.out.println("Title is expected");
        }else {
            System.out.println("Title is NOT expected");
        }
        //MEETING ID FOR TODAY CLASS: 949992072
        HashMap <String, String> contact1 = new HashMap<>();
        contact1.put("First Name", "John");
        contact1.put("Last Name", "Smith");
        contact1.put("Phone", "571-236-4545");
        contact1.put("Street", "400 Main Street");
        contact1.put("City", "Tysons");
        contact1.put("State", "VA");
        contact1.put("Zip Code", "22102");
        contact1.put("Sales Group", "true");
        contact1.put("Country", "United States");
        System.out.println("Contact 1: " + contact1);
        WebElement first_name = driver.findElement(By.xpath("(//input[@data-name = 'field__first-name'])[1]"));
        WebElement last_name = driver.findElement(By.xpath("(//input[@data-name = 'field__last-name'])[1]"));
        WebElement phone = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        WebElement street = driver.findElement(By.name("oro_contact_form[addresses][0][street]"));
        WebElement city = driver.findElement(By.name("oro_contact_form[addresses][0][region_text]"));
        WebElement state = driver.findElement(By.name("oro_contact_form[addresses][0][region_text]"));
        WebElement zipCode = driver.findElement(By.name("oro_contact_form[addresses][0][postalCode]"));
        WebElement salesGroup = driver.findElement(By.xpath("(//input[@data-name = 'field__1'])[2]"));

        WebElement country = driver.findElement(By.name("oro_contact_form[addresses][0][country]"));
        Select country_dropdown = new Select(country);
        country_dropdown.selectByVisibleText(contact1.get("Country"));
        if (contact1.get("Sales Group").equalsIgnoreCase("true")){
            salesGroup.click();
        }

    }
}