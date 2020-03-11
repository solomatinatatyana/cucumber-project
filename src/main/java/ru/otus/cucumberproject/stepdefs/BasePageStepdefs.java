package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.cucumberproject.CucumberProjectApplication;
import ru.otus.cucumberproject.config.BrowserType;
import ru.otus.cucumberproject.config.Config;
import ru.otus.cucumberproject.services.driver.WebApplicationService;

@SpringBootTest(classes =  CucumberProjectApplication.class)
@ContextConfiguration(classes = Config.class)
@DirtiesContext
public class BasePageStepdefs {

    @Autowired
    WebApplicationService webApplicationService;

    protected  static String browser = System.getProperty("browser").toLowerCase();

    @Before
    public void before() {
        System.out.println("before scenario");
        System.out.println("Browser: " + BrowserType.valueOf(browser));
    }

    @After
    public void after(){
        System.out.println("end of scenario");
        webApplicationService.closeDriver();
    }
}
