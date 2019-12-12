/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;

/**
 *
 * @author AKravchuk
 */
public class TestSelenium {
    
    private static WebDriver driver;

    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver",
//                           "D:\\Programming\\JavaProjects\\TestSelenium\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
        driver = new ChromeDriver();
        test1();
        driver.quit();
          
    }
    
    public static void test1() {
        driver.get("https://www.google.com/");
        driver.manage().window().setSize(new Dimension(966, 991));
/*
        driver.findElement(By.id("fakebox"));
        driver.findElement(By.name("q"));
        driver.findElement(By.className("q"));
        driver.findElement(By.xpath("//*[@id=\"fakebox-container\"]"));
        driver.findElement(By.tagName("div"));
        driver.findElement(By.linkText("Шукайте в Google або введіть URL-адресу"));
        driver.findElement(By.partialLinkText("Шукайте"));
        driver.findElement(By.cssSelector("input[type='submit']"));
        
        in browser console:
        document.querySelectorAll('[name="btnK"]')
        document.querySelectorAll('[id="gb"]')
        
*/        
/*
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("testing with java");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
*/
        WebElement search = driver.findElement(By.name("q"));
        search.click();
        search.clear();
        search.sendKeys("testing with java");
        search.sendKeys(Keys.ENTER);
        String title = driver.getTitle();
        String expectedResult = "testing with java - Поиск в Google";
        System.out.println(driver.getTitle());
        assertEquals(expectedResult, title);
        
    }

}
