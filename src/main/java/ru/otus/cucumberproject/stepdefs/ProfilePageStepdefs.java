package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.cucumberproject.pagesandblocks.pages.ProfilePage;

public class ProfilePageStepdefs {
    private static final Logger logger = LogManager.getLogger(ProfilePageStepdefs.class);
    @Autowired
    private ProfilePage profilePage;

    @Then("I should see \"(.*)\"")
    public void check(String something){
        logger.info("Проверяем имя пользователя");
        WebDriverWait wait = new WebDriverWait(profilePage.driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(profilePage.firstNameTextInput));
        Assert.assertEquals(profilePage.firstNameTextInput.getAttribute("value"),something);
        logger.info("Проверка пройдена успешно");
    }
}
