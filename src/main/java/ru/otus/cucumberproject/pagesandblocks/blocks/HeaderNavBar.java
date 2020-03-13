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
public class HeaderNavBar {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//a[@class = 'header2_subheader-link' and @title = 'Рекрутерам']")
    public WebElement recruiters;

    @FindBy(xpath = ".//a[@class = 'header2_subheader-link' and @title = 'Отзывы']")
    public WebElement reviews;

    @FindBy(xpath = ".//a[@class = 'header2_subheader-link' and @title = 'FAQ']")
    public WebElement faq;

    @FindBy(xpath = ".//a[@class = 'header2_subheader-link' and @title = 'Блог']")
    public WebElement posts;

    @FindBy(xpath = ".//a[@class = 'header2_subheader-link' and @title = 'Контакты']")
    public WebElement contacts;
}
