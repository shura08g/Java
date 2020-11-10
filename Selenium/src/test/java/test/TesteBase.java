package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.TaskOne;
import page.TaskSix;


public class TesteBase {
    //String SITE_URL = "https://testingcup.pgs-soft.com/";
    WebDriver driver;
    public Main main;
    public TaskOne taskOne;
    public TaskSix taskSix;
    
    //@Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        //System.out.println("Before each test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        main = PageFactory.initElements(driver, Main.class);
        taskOne = PageFactory.initElements(driver, TaskOne.class);
        taskSix = PageFactory.initElements(driver, TaskSix.class);
    }
    
    //@After
    public void finish() {
        if (driver != null) {
            driver.quit();
        }
        //System.out.println("After each test");
    }
}
