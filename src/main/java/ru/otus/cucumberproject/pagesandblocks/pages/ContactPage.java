package ru.otus.cucumberproject.pagesandblocks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ContactPage {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    public WebElement findNetwork(String network){
        return (new WebDriverWait(driver, 50L))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@class='contacts__social hover-ic']/span[text()='"+network+"']")));
    }
}
