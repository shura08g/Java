package net.bugoff.selenide.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.bugoff.selenide.pages.General;
import net.bugoff.selenide.pages.Main;

public class MainSteps {
    Main main = new Main();
    General general = new General();

    @Given("I am on main page")
    public void iAmOnMainPage() {
        main.open();
    }

    @When("I click {string} tab")
    public void iClickTab(String tabName) {
        general.openTab(tabName);
    }

}
