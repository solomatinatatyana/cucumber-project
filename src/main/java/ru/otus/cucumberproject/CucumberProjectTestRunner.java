package ru.otus.cucumberproject;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"ru.otus.cucumberproject.stepdefs"},
        tags = {"@All"}
)
public class CucumberProjectTestRunner extends AbstractTestNGCucumberTests {

}
