package net.bugoff.selenide.steps;

import io.cucumber.java.en.Then;
import net.bugoff.selenide.pages.Dresses;

public class DressesSteps {
    Dresses dresses = new Dresses();

    @Then("I am on dresses page")
    public void iAmOnDressesPage() {
        dresses.iAmOnDressesPage();
    }
}
