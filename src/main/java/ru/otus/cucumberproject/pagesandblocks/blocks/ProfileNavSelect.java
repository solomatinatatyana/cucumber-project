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
public class ProfileNavSelect {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title = 'Личный кабинет']")
    public WebElement profile;

    @FindBy(xpath = "//a[@title = 'Личный кабинет']")
    public WebElement myProfile;
}
