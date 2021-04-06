package test.automatedtesting;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\tools\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        
    /*    driver.get("https://google.com");
        
// Явное ожидание появления элемента
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        
// Неявное ожидание появления элемента
        WebElement field = (new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("q"))));
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        element.sendKeys("Automated Testing");
    */
    
// getAttribute    
    /*  driver.get("https://www.avito.ru/rossiya/avtomobili");
        
        
        WebElement element = driver.findElement(By.xpath("(//a[text()='Личные вещи'])[1]"));
        String par = element.getAttribute("offsetWidth");
        String link = element.getAttribute("href");
        System.out.println(par);  //95
        System.out.println(link);  //https://www.avito.ru/rossiya/lichnye_veschi?cd=1
    */
    
// getText         
    /*    driver.get("https://www.avito.ru/rossiya");
        
        WebElement element = driver.findElement(By.cssSelector(".category-with-counters-count-29J0p.category-with-counters-count_item-3tm8b"));
        String text = element.getText();
        System.out.println(text);  // 31 202 370
    */
    
// getCssValue
    /*    driver.get("https://dev.by/");
        
        WebElement element = driver.findElement(By.xpath("//a[text()='Вход']"));
        String css = element.getCssValue("display");
        System.out.println(css); // flex*/

// sendKeys
    /*    driver.get("https://udemy.com/");
        
        WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
        //element.sendKeys("test", Keys.ENTER);
        element.sendKeys("test");
        */
        
// Actions
        
        
        try {
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop");
            Thread.sleep(2000);
            WebElement element1 = driver.findElement(By.id("draggable"));
            WebElement element2 = driver.findElement(By.id("droppable"));
            Actions actions = new Actions(driver);
            // Variant #1
            //actions.dragAndDrop(element1, element2).perform();
            // Variant #2
            actions.moveToElement(element1)
                    .clickAndHold()
                    .moveToElement(element2)
                    .release()
                    .build()
                    .perform();
            
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
        

        
        //driver.close();
        
        
        
    }
    
}
