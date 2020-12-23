import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;



public class WomenTest {

    @Before
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("http://automationpractice.com");
    }

    @Test
    public void checkIfIOnWomenPage(){
        element(By.linkText("Women")).click();
        element(By.xpath("//h2[@class='title_block']")).shouldHave(text("WOMEN"));
    }

    @Test
    public void searchProduct(){
        element(By.id("search_query_top")).setValue("Blouse").pressEnter();
        element(By.xpath("//img[@title='Blouse']")).shouldBe(visible);
        element(byText("1 result has been found.")).should(exist);
    }


    @Test
    public void addProductToCart(){
        SelenideElement product = element(By.linkText("Faded Short Sleeve T-shirts"));

        //scroll to the first product
        product.scrollTo();
        //move mouse to the first product
        actions().moveToElement(product).perform();
        //click on Quick view element on the product
        element(By.xpath("(//a[@class='quick-view'])[1]")).click();
        //switch to iFrame
        switchTo().frame(element(By.className("fancybox-iframe")));
        //fill quantity field
        element(By.id("quantity_wanted")).setValue("2");
        //select size
        element(By.id("group_1")).selectOption("M");
        //click on Add product
        element(By.id("add_to_cart")).click();
        //click Proceed to checkout
        element(byText("Proceed to checkout")).click();
        //check if 2 products in cart
        element(By.id("summary_products_quantity")).shouldHave(text("2 Products"));
    }

    @Test
    public void testIfProductHasSocialNetworkButtons(){
        selectProduct("Blouse");
        elements(".socialsharing_product.list-inline.no-print>button").shouldHave(exactTexts("Tweet","Share", "Google+", "Pinterest"));
        elements(By.xpath("//button[@type='button']")).shouldHave(exactTexts("Tweet","Share", "Google+", "Pinterest"));

    }

    public void selectProduct(String productName){
        elements(".product_img_link").filterBy(attribute("title", productName)).first().click();
    }

}

