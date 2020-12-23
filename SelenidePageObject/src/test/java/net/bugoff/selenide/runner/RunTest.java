package net.bugoff.selenide.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"},
        glue = {"net/bugoff/selenide/steps"}, plugin = {"pretty"})
public class RunTest {
}
