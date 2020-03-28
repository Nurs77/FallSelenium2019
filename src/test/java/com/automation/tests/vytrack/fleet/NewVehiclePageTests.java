package com.automation.tests.vytrack.fleet;

import com.automation.pages.AbstractPageBase;
import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclePage;
import com.automation.tests.utilities.BrowserUtils;
import com.automation.tests.utilities.Driver;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclePageTests extends AbstractTestBase {
    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        VehiclePage vehiclesPage = new VehiclePage();
BrowserUtils.wait(3);
        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");
BrowserUtils.wait(3);
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
    }


