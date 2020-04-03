package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.asserts.SoftAssert;
import ru.otus.cucumberproject.pagesandblocks.pages.MainPage;
import ru.otus.cucumberproject.pagesandblocks.pages.ProfilePage;

public class MainPageStepdefs {

    private static final Logger logger = LogManager.getLogger(MainPageStepdefs.class);
    private SoftAssert softAssert = new SoftAssert();

    @Autowired
    private MainPage mainPage;
    @Autowired
    private ProfilePage profilePage;

    @Value("${sut.url}")
    private String url;

    @Value("${site.login}")
    private String login;

    @Value("${site.password}")
    private String password;

    @Value("${site.login2}")
    private String login2;

    @Value("${site.password2}")
    private String password2;

    @Given("I open main page")
    public void openPage() {
        mainPage.openUrl(url);
        logger.info("open page " + url);
    }

    @When("I login to test account")
    public void login(){
        mainPage.doLogin(login,password);
        logger.info("login by user: {}", login);
    }

    @When("I login to test2 account")
    public void login2(){
        mainPage.doLogin(login2,password2);
        logger.info("login by user: {}", login2);
    }

    @When("I login with \"(.*)\" password")
    public void login(String password){
        mainPage.doLogin(login,password);
        logger.info("login by user: {}", login);
    }

    @Then("I'am on URL \"(.*)\"")
    public void checkUrl(String url){
        Assert.assertEquals(mainPage.driver.getCurrentUrl(),url);
    }

    @Then("I should see error \"(.*)\" message and color is \"(.*)\"")
    public void checkLoginError(String message, String color){
        logger.info("Проверяем сообщение об ошибке '{}'",message);
        WebElement incorrectLabel = (new WebDriverWait(mainPage.driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(mainPage.incorrectLabel));
        softAssert.assertEquals(incorrectLabel.getText(),message,
                "Неверный текст сообщения");
        softAssert.assertEquals(Color.fromString(incorrectLabel.getCssValue("color")).asHex(),color,
                "Цвет сообщения не #9a0f0f (красный)");
        softAssert.assertAll();
    }

    @When("I go to profile")
    public void goToProfile(){
        logger.info("Переходим в раздел 'О себе'");
        profilePage.goToMyProfile();
        profilePage.goToBiography();
    }

    @When("I go to settings")
    public void goToPage(){
        logger.info("Переходим в раздел 'Настройки'");
        profilePage.goToMyProfile();
        profilePage.goToSettings();
    }

    @When("^I drillDown to \"([^\"]*)\"$")
    public void iDrillDownToTopic(String category) {
        logger.info("Переходм на {}", category);
        mainPage.onDrillDown(category);
    }

    @When("^I logout from account$")
    public void iLogoutFromAccount() {
        logger.info("Разлогиниваемся");
        mainPage.logout();
    }
}
