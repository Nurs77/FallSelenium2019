package com.automation.tests.day13;

import com.automation.tests.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {
    @Test
    public void readProperties(){
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        System.out.println(browser);
        System.out.println(url);
        String storeManager = ConfigurationReader.getProperty("store_manager");
        System.out.println("storeManager = " + storeManager);
        System.out.println(ConfigurationReader.getProperty("password"));

    }
}
