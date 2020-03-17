package ru.otus.cucumberproject.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.otus.cucumberproject.pagesandblocks.pages.ProfilePage;

public class ProfilePageStepdefs {
    private static final Logger logger = LogManager.getLogger(ProfilePageStepdefs.class);
    private SoftAssert softAssert = new SoftAssert();
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

    @When("^I upload photo to profile$")
    public void iUploadPhotoToProfile() {
        logger.info("Загружаем аватар");
        profilePage.uploadPhoto("src/main/resources/images/avatar.jpg");
    }

    @And("^I click to choose button$")
    public void iClickToChooseButton() {
        profilePage.choose();
    }

    @Then("^I should see error message \"([^\"]*)\" with background color \"([^\"]*)\"$")
    public void iShouldSeeErrorMessageWithBackgroundColor(String message, String color) throws Throwable {
        WebDriverWait wait = new WebDriverWait(profilePage.driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(profilePage.notificationError));
        softAssert.assertTrue(profilePage.notificationError.isDisplayed(),"Сообщение об ошибке не отображается");
        softAssert.assertEquals(profilePage.notificationError.getText(),message,"Неверный текст сообщения");
        softAssert.assertEquals(Color.fromString(profilePage.notificationError.getCssValue("color")).asHex(),color,
                "Цвет сообщения не #9a0f0f (красный)");
        softAssert.assertAll();
        throw new PendingException();
    }
}
