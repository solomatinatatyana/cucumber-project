package ru.otus.cucumberproject;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.springframework.test.annotation.DirtiesContext;

@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"ru.otus.cucumberproject.stepdefs"},
        tags = {"@LoginProfile"}
)
public class CucumberProjectTestRunner extends AbstractTestNGCucumberTests {

}
