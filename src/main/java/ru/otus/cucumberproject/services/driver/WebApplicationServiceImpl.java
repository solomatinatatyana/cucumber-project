package ru.otus.cucumberproject.services.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Service
public class WebApplicationServiceImpl implements WebApplicationService {
    private WebDriver driver;

    @Override
    public WebDriver getChromeDriver(MutableCapabilities options) {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments(Arrays.asList("--start-maximized",
                    "--allow-file-access-from-files",
                    "--allow-running-insecure-content",
                    "--disable-notifications",
                    "--disable-infobars",
                    "--disable-file-cookies",
                    "--disable-web-security",
                    "--disable-extensions",
                    "--disable-feature=VizDisplayCompositor",
                    "--incognito"));
            options.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new ChromeDriver();
            this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            this.driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
            this.driver.manage().window().maximize();
        }
        return driver;
    }

    @Override
    public WebDriver getFirefoxDriver(MutableCapabilities options) {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            options.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
            driver = new FirefoxDriver();
            this.driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            this.driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
            this.driver.manage().window().maximize();
        }
        return driver;
    }

    @Override
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
