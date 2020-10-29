package test;

import org.junit.Test;
/* TestNG */
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;*/

public class First extends TesteBase {
    /* TestNG  */ 
   /* @BeforeMethod
    public void start() {
        //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        System.out.println("Before each test");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @AfterMethod
    public void finish() {
        driver.quit();
        System.out.println("After each test");
    }*/
    
    @Test
    public void firstTest() {
        main.goTo()
            .chooseTask("1");
        //main.chooseTask("1");
        taskOne.checkPageIsCorrect();
    }

/*    @Test
    public void secondTest() {
        
    }*/
}
