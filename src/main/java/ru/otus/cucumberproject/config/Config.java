package ru.otus.cucumberproject.config;


import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.cucumberproject.services.driver.WebApplicationService;

@PropertySource("classpath:properties/application.properties")
@Configuration
@ComponentScan
@DirtiesContext
public class Config {

    protected WebDriver driver;
    protected MutableCapabilities options;
    protected  static String browser = System.getProperty("browser").toUpperCase();

    @Autowired
    private WebApplicationService webApplicationService;

    @Bean(value="chrome")
    public WebDriver getDriver() {
        this.options = new MutableCapabilities();
        this.driver = webApplicationService.getChromeDriver(options);
        return this.driver;
    }

    @Bean(value="firefox")
    public WebDriver getOtherDriver() {
        this.options = new MutableCapabilities();
        this.driver = webApplicationService.getFirefoxDriver(options);
        return this.driver;
    }
}
