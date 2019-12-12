package com.mycompany.testmaven;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    public ChromeDriver driver;
    
    @Before
    public void setUt() {
        System.setProperty("webdriver.chrome.driver", "target/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test start...");
    }
    
    @After
    public void tearDown() {
        driver.quit();
        System.out.println("Test finish.");
    }
    
}
