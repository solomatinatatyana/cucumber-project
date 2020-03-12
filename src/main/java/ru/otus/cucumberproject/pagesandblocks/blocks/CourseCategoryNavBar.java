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
public class CourseCategoryNavBar {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//a[@class='nav__item course-categories__nav-item' and @title = 'Программирование']")
    public WebElement programmingTab;

    @FindBy(xpath = ".//a[@class='nav__item course-categories__nav-item' and @title = 'Инфраструктура']")
    public WebElement infrastructureTab;

    @FindBy(xpath = ".//a[@class='nav__item course-categories__nav-item' and @title = 'Информационная безопасность']")
    public WebElement ISTab;

    @FindBy(xpath = ".//a[@class='nav__item course-categories__nav-item' and @title = 'Data Science']")
    public WebElement dataScienceTab;

    @FindBy(xpath = ".//a[@class='nav__item course-categories__nav-item' and @title = 'Управление']")
    public WebElement managementTab;

    @FindBy(xpath = ".//a[@class='nav__item course-categories__nav-item' and @title = 'Тестирование']")
    public WebElement testingTab;
}
