package ru.otus.cucumberproject.pagesandblocks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.otus.cucumberproject.pagesandblocks.blocks.ProfileNavBar;
import ru.otus.cucumberproject.pagesandblocks.blocks.ProfileNavSelect;

import javax.annotation.PostConstruct;

@Component
public class ProfilePage {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @Autowired
    public ProfileNavSelect profileSelectElements;
    @Autowired
    public ProfileNavBar profileNavBar;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = ".//div[contains(@class,'header2-menu__item-wrapper__username')]")
    public WebElement profileSelect;

    @FindBy(css = "input[name='fname']")
    public WebElement firstNameTextInput;

    public void goToBiography(){
        WebDriverWait wait = new WebDriverWait(driver,50L);
        wait.until(ExpectedConditions.visibilityOf(profileNavBar.biography));
        profileNavBar.biography.click();
    }

    public void goToMyProfile(){
        WebDriverWait wait = new WebDriverWait(driver,50L);
        wait.until(ExpectedConditions.visibilityOf(profileSelect));
        Actions builder = new Actions(driver);
        builder.moveToElement(profileSelect).perform();
        profileSelectElements.profile.click();
    }

}
