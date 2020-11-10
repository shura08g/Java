package page;

import java.util.List;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaskSix extends BasePage {
    public TaskSix(WebDriver driver) {
        super(driver);
    }
    
    public TaskSix fillInLogin(String login) {
        writeText(By.id("LoginForm__username"), login);
        return this;
    }
    
    public TaskSix fillInPassword(String login) {
        writeText(By.name("LoginForm[_password]"), login);
        return this;
    }
    
    public TaskSix loginButtonClick() {
        //click(By.cssSelector(".btn-default.btn"));
        click(By.xpath("//button[text()='Login']"));
        return this;
    }
    
    public TaskSix isLoginCorrect() {
        isElementDisplayed(By.linkText("Pobierz plik"));
        return this;
    }
    
    public TaskSix checkAllElementsOnPagePresent() {
        isElementDisplayed(By.id("LoginForm__username"));
        isElementDisplayed(By.name("LoginForm[_password]"));
        isElementDisplayed(By.cssSelector(".btn-default.btn"));
        return this;
    }
    
    public TaskSix isLoginWrong() {
        //assertFalse(driver.findElements(By.linkText("Pobierz plik")).size() > 0);
        isElementNotDisplayed(By.linkText("Pobierz plik"));
        return this;
    }
    
}
