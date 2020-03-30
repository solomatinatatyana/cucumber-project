package ru.otus.cucumberproject.pagesandblocks.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.otus.cucumberproject.pagesandblocks.blocks.ProfileNavBar;
import ru.otus.cucumberproject.pagesandblocks.blocks.ProfileNavSelect;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.function.Function;

@Component
public class ProfilePage {
    private Logger logger = LogManager.getLogger(ProfilePage.class);
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

    public By avatarLocator= By.cssSelector(".js-avatar");

    @FindBy(xpath = ".//div[contains(@class,'header2-menu__item-wrapper__username')]")
    public WebElement profileSelect;

    @FindBy(css = "input[name='fname']")
    public WebElement firstNameTextInput;

    @FindBy(css = ".settings-photo__buttons")
    public WebElement uploadForm;

    @FindBy(css = "input[type='file']")
    public WebElement uploadFileInput;

    @FindBy(css = ".js-choose-crop")
    public WebElement chooseButton;

    @FindBy(css = ".notification-lib_error")
    public WebElement notificationError;

    @FindBy(css = ".js-avatar")
    public WebElement avatar;

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

    public void goToSettings(){
        WebDriverWait wait = new WebDriverWait(driver,50L);
        wait.until(ExpectedConditions.visibilityOf(profileNavBar.settings));
        profileNavBar.settings.click();
    }

    public void uploadPhoto(String path){
        WebDriverWait wait = new WebDriverWait(driver,50L);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.uploadForm));
        File file = new File(path);
        this.uploadFileInput.sendKeys(file.getAbsolutePath());
    }

    public void choose(){
        WebDriverWait wait = new WebDriverWait(driver,50L);
        wait.until(ExpectedConditions.visibilityOfAllElements(this.chooseButton));
        chooseButton.click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public Function<? super WebDriver, Object> isAvatarUploaded = new ExpectedCondition<Object>() {
        @NullableDecl
        @Override
        public Object apply(@NullableDecl WebDriver webDriver) {
            return webDriver.findElement(avatarLocator).getAttribute("class").contains("settings-photo__photo_empty");
        }
    };
}
