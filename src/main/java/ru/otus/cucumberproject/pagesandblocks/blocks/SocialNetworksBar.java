package ru.otus.cucumberproject.pagesandblocks.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SocialNetworksBar {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }


}
