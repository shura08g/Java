/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testselenium;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author AKravchuk
 */
public class TestClass {
    
    public TestClass() {
    }
    
    private WebDriver driver = null;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                           "D:\\Programming\\JavaProjects\\TestSelenium\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test1() {
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

      // TODO add test methods here.
      // The methods must be annotated with annotation @Test. For example:
      //
      // @Test
      // public void hello() {}
}
