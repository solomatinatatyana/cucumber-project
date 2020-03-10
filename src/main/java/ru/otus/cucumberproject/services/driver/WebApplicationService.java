package ru.otus.cucumberproject.services.driver;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface WebApplicationService {
    WebDriver getChromeDriver(MutableCapabilities options);
    WebDriver getFirefoxDriver(MutableCapabilities options);
    void closeDriver();
}
