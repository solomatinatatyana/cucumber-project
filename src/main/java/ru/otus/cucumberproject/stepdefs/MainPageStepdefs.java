package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import ru.otus.cucumberproject.config.Config;
import ru.otus.cucumberproject.pagesandblocks.pages.MainPage;

public class MainPageStepdefs {

    private static final Logger logger = LogManager.getLogger(MainPageStepdefs.class);

    @Autowired
    private MainPage mainPage;

    @Value("${sut.url}")
    private String url;

    @Value("${site.login}")
    private String login;

    @Value("${site.password}")
    private String password;

    @Given("I open main page")
    public void openPage() {
        mainPage.openUrl(url);
        logger.info("open page " + url);
    }

    @When("I login with \"(.*)\" and \"(.*)\"")
    public void login(String login, String password){
        mainPage.doLogin(login,password);
    }

    @Then("I'am on URL \"(.*)\"")
    public void checkUrl(){

    }

    @Then("I'am on the My profile page on URL \"(.*)\"")
    public void checkLogin(){

    }
}
