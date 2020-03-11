package ru.otus.cucumberproject.pagesandblocks.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ProfileNavBar {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//a[@title = 'Мои курсы']")
    public WebElement myCourses;

    @FindBy(xpath = ".//a[@title = 'Оплата']")
    public WebElement payment;

    @FindBy(xpath = ".//a[@title = 'О себе']")
    public WebElement biography;

    @FindBy(xpath = ".//a[@title = 'Приведи друга']")
    public WebElement invite;

    @FindBy(xpath = ".//a[@title = 'Работа в кампаниях']")
    public WebElement employment;

    @FindBy(xpath = ".//a[@title = 'Настройки']")
    public WebElement settings;

    @FindBy(xpath = ".//a[@title = 'Документы']")
    public WebElement documents;
}
