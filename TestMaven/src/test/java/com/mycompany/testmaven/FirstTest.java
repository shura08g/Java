package com.mycompany.testmaven;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstTest extends WebDriverSettings {
/*   
    private ChromeDriver driver;
    
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
*/
    
    @Test
    public void firstTest() {
        driver.get("https://www.google.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        // document.querySelectorAll('[id="SIvCob"]')
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SIvCob")));
        String title = driver.getTitle();
        String expected = "Google";
        assertEquals(expected, title);
    }
    
//    @FindBy(name="q")
//    private WebElement search;
    
    @Test
    public void secondTest() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(966, 991));
        WebElement search = driver.findElement(By.name("q"));
        search.click();
        search.clear();
        search.sendKeys("testing with java");
        search.sendKeys(Keys.ENTER);
        String title = driver.getTitle();
        String expectedResult = "testing with java - Поиск в Google";
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        assertEquals(expectedResult, title); 
    }
    
}
