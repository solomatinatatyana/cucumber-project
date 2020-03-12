package ru.otus.cucumberproject.pagesandblocks.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class CoursePage {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @FindBy(css = "div[class='lessons']>a")
    public List<WebElement> courses;

    @FindBy(xpath = ".//div[text()='В разработке']")
    public List<WebElement> coursesInDevelopment;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    public int getAllCoursesCount(){
        return courses.size();
    }

    public int getCoursesInDevelopmentCount(){
        return coursesInDevelopment.size();
    }

}
