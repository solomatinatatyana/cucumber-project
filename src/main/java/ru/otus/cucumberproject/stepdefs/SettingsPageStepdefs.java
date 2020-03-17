package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.otus.cucumberproject.pagesandblocks.pages.SettingsPage;

public class SettingsPageStepdefs {
    private static final Logger logger = LogManager.getLogger(SettingsPageStepdefs.class);
    private SoftAssert softAssert = new SoftAssert();

    @Autowired
    private SettingsPage settingsPage;


    @Then("I should see change password error \"(.*)\" message and color is \"(.*)\" on settings page")
    public void checkChangePasswordError(String message, String color){
        logger.info("Проверяем сообщение об ошибке '{}'",message);
        WebElement incorrectLabel = (new WebDriverWait(settingsPage.driver, 10))
                .until(ExpectedConditions.visibilityOf(settingsPage.labelError));
        softAssert.assertEquals(incorrectLabel.getText(),message,
                "Неверный текст сообщения");
        softAssert.assertEquals(Color.fromString(incorrectLabel.getCssValue("color")).asHex(),color,
                "Цвет сообщения не #960000 (красный)");
        softAssert.assertAll();
        logger.info("Проверка пройдена успешно");
    }


    @And("^I input new \"([^\"]*)\" to change form$")
    public void iInputNewToChangeForm(String pass){
        logger.info("Меняем пароль на {}", pass);
        settingsPage.changePassword(pass);
        logger.info("Пароль успешно изменен");
    }

    @And("^I input new password \"([^\"]*)\" to change form$")
    public void iInputNewPasswordToChangeForm(String pass){
        logger.info("Меняем пароль на {}", pass);
        WebDriverWait wait = new WebDriverWait(settingsPage.driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(settingsPage.password));
        settingsPage.password.clear();
        settingsPage.password.sendKeys(pass);
    }

    @And("^I input new password-check \"([^\"]*)\" to change form$")
    public void iInputNewPasswordCheckToChangeForm(String pass){
        logger.info("Подтверждение пароля - {}", pass);
        WebDriverWait wait = new WebDriverWait(settingsPage.driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(settingsPage.passwordCheck));
        settingsPage.passwordCheck.clear();
        settingsPage.passwordCheck.sendKeys(pass);
    }

    @And("^I save changes$")
    public void iSaveChanges(){
        logger.info("Сохраняем настройки");
        settingsPage.saveButton.click();
    }

    @Then("^I should see change successful message \"([^\"]*)\"$")
    public void iShouldSeeChangeSuccessfulMessage(String message) {
        logger.info("Проверяем сообщение об успешной смене пароля '{}'",message);
        WebElement correctLabel = (new WebDriverWait(settingsPage.driver, 10))
                .until(ExpectedConditions.visibilityOf(settingsPage.labelSuccess));
        Assert.assertEquals(correctLabel.getText(),message, "Неверный текст сообщения");
    }
}
