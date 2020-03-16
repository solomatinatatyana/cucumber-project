package ru.otus.cucumberproject.pagesandblocks.pages;

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
public class SettingsPage {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[name='password']")
    public WebElement password;

    @FindBy(css = "input[name='password_check']")
    public WebElement passwordCheck;

    @FindBy(xpath = ".//button[text()='Сохранить']")
    public WebElement saveButton;

    @FindBy(css = "div[class='input-line']>p")
    public WebElement labelError;

    @FindBy(css = "div[class='hide-sm']>div>span>span")
    public WebElement labelSuccess;

    public void changePassword(String pass){
        WebDriverWait wait = new WebDriverWait(driver, 50L);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.clear();
        password.sendKeys(pass);
        passwordCheck.clear();
        passwordCheck.sendKeys(pass);
        saveButton.click();
    }
}
