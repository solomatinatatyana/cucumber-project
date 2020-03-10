package ru.otus.cucumberproject.pagesandblocks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MainPage {
    @Autowired
    @Qualifier("chrome")
    private WebDriver driver;

    private By loginForm = By.cssSelector("form.new-log-reg__form.js-login");
    private By username = By.cssSelector("input[name=email]");
    private By pass = By.cssSelector("input[type=password]");
    private By submit = By.cssSelector("button[type='submit']");

    /**Кнопка "Войти и Регистрация"*/
    @FindBy(css = "button[class='header2__auth js-open-modal']")
    public WebElement signButton;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void doLogin(String login, String password) {
        login(login, password);
    }

    private void login(String login, String password){
        loginUI(login, password);
    }

    private void loginUI(String login, String password) {
        this.signButton.click();
        WebElement loginFormElem = (new WebDriverWait(driver,50L)
                .until(ExpectedConditions.visibilityOfElementLocated(loginForm)));
        loginFormElem.findElement(username).clear();
        loginFormElem.findElement(username).sendKeys(login);
        loginFormElem.findElement(pass).clear();
        loginFormElem.findElement(pass).sendKeys(password);
        loginFormElem.findElement(submit).click();
    }
}
