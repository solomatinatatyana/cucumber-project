package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import ru.otus.cucumberproject.config.Config;
import ru.otus.cucumberproject.services.driver.WebApplicationService;

@ContextConfiguration(classes = Config.class)
public class BasePageStepdefs {

    @Autowired
    WebApplicationService webApplicationService;

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after(){
        System.out.println("after hooks");
        webApplicationService.closeDriver();
    }
}
