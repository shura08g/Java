package net.bugoff.selenide.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.elements;

public class Women {
    public Women open() {
        Selenide.open("http://automationpractice.com/index.php?id_category=3&controller=category");
        return this;
    }

    public void iAmOnWomenPage(){
        element(By.xpath("//h2[@class='title_block']")).shouldHave(text("WOMEN"));
    }

    public void subCategories(){
        elements(By.xpath("//div[@id='subcategories']/ul/li")).shouldHave(exactTexts("TOPS","DRESSES"));
    }
}
