package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.otus.cucumberproject.pagesandblocks.pages.MainPage;

public class MainPageStepdefs {

    private static final Logger logger = LogManager.getLogger(MainPageStepdefs.class);

    @Autowired
    private MainPage mainPage;

    @Value("${sut.url}")
    private String url;

    @Given("I open main page")
    public void openPage() {
        mainPage.openUrl(url);
        logger.info("open page" + url);
    }

}
