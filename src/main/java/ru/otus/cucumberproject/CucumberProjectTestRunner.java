package ru.otus.cucumberproject;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.cucumberproject.config.Config;

@ContextConfiguration(classes = Config.class)
@CucumberOptions(
        features = {"src/main/resources/features/"},
        glue = {"ru.otus.cucumberproject.stepdefs"},
        tags = {"@test"}
)
public class CucumberProjectTestRunner extends AbstractTestNGCucumberTests {

}
