package ru.otus.cucumberproject.pagesandblocks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import ru.otus.cucumberproject.pagesandblocks.blocks.CourseCategoryNavBar;
import ru.otus.cucumberproject.pagesandblocks.blocks.HeaderNavBar;

import javax.annotation.PostConstruct;

@Component
public class MainPage {
    @Autowired
    @Qualifier("chrome")
    public WebDriver driver;

    @Autowired
    public CourseCategoryNavBar courseCategoryNavBar;
    @Autowired
    public HeaderNavBar headerNavBar;
    @Autowired
    public ProfilePage profilePage;


    private By loginForm = By.cssSelector("form.new-log-reg__form.js-login");
    private By username = By.cssSelector("input[name=email]");
    private By pass = By.cssSelector("input[type=password]");
    private By submit = By.cssSelector("button[type='submit']");
    public By incorrectLabel = By.cssSelector("div.new-input-error.new-input-error_top.new-input-error_form.js-text");
    private By cookiesAgreeButton = By.cssSelector(".cookies.js-cookie>div>button");

    /**
     * Кнопка "Войти и Регистрация"
     */
    @FindBy(css = "button[class='header2__auth js-open-modal']")
    public WebElement signButton;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public void doLogin(String login, String password) {
        login(login, password);
    }

    private void login(String login, String password) {
        loginUI(login, password);
    }

    private void loginUI(String login, String password) {
        this.signButton.click();
        WebElement loginFormElem = (new WebDriverWait(driver, 50L)
                .until(ExpectedConditions.visibilityOfElementLocated(loginForm)));
        loginFormElem.findElement(username).clear();
        loginFormElem.findElement(username).sendKeys(login);
        loginFormElem.findElement(pass).clear();
        loginFormElem.findElement(pass).sendKeys(password);
        loginFormElem.findElement(submit).click();
     }

    public void onDrillDown(String tab) {
        WebElement cookies = (new WebDriverWait(driver, 50L))
                .until(ExpectedConditions.presenceOfElementLocated(cookiesAgreeButton));
        cookies.click();
        switch (tab){
            case "Программирование":
            case "Инфраструктура":
            case "Информационная безопасность":
            case "Data Science":
            case "Управление":
            case "Тестирование":
                WebElement tabElement = (new WebDriverWait(driver, 50L))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@class='nav__item course-categories__nav-item' and @title = '" + tab + "']")));
                tabElement.click();
                break;
            case "Контакты":
                WebElement headerElement = (new WebDriverWait(driver, 50L))
                        .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@class = 'header2_subheader-link' and @title = '"+tab+"']")));
                headerElement.click();
                break;
        }
        //document.querySelector('a[href="/contacts/"]').click();
    }

    public void logout(){
        WebDriverWait wait = new WebDriverWait(driver,50L);
        wait.until(ExpectedConditions.visibilityOf(profilePage.profileSelect));
        Actions builder = new Actions(driver);
        builder.moveToElement(profilePage.profileSelect).perform();
        profilePage.profileSelectElements.logoutButton.click();
    }
}
