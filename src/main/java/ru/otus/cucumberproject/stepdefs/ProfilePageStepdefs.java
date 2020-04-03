package ru.otus.cucumberproject.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import ru.otus.cucumberproject.pagesandblocks.pages.ProfilePage;

public class ProfilePageStepdefs {
    private static final Logger logger = LogManager.getLogger(ProfilePageStepdefs.class);
    private SoftAssert softAssert = new SoftAssert();
    @Autowired
    private ProfilePage profilePage;

    private String profileName;

    @Value("${profile.name}")
    private String profileName1;

    @Value("${profile.name2}")
    private String profileName2;

    @Then("I should see profile name profile name")
    public void check(){
        logger.info("Проверяем имя пользователя");
        WebDriverWait wait = new WebDriverWait(profilePage.driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(profilePage.firstNameTextInput));
        Assert.assertEquals(profilePage.firstNameTextInput.getAttribute("value"),profileName);
        logger.info("Проверка пройдена успешно. Имя пользователя - {}", profileName);
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

    @Then("^I should not see empty avatar$")
    public void iShouldNotSeeEmptyAvatar() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(profilePage.driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(profilePage.avatar));
        Thread.sleep(1000);// очень плохо, но по-другому не получилось(((
        //profilePage.isAvatarUploaded.apply(profilePage.driver);
        Assert.assertFalse(profilePage.avatar.getAttribute("class").contains("settings-photo__photo_empty"),"Аватар не установлен");
        throw new PendingException();
    }

    @Given("^profile name is profile name is (\\d+)$")
    public void profileNameIsProfileNameIs(int profileCount) {
        switch (profileCount){
            case 1:
                profileName = profileName1;
                break;
            case 2:
                profileName = profileName2;
                break;
        }
        logger.info("Имя профиля должно быть - {}", profileName);
    }
}
