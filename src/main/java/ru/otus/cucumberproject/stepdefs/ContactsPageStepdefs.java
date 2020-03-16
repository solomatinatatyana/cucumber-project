package ru.otus.cucumberproject.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.asserts.SoftAssert;
import ru.otus.cucumberproject.pagesandblocks.pages.ContactPage;

public class ContactsPageStepdefs {
    private static final Logger logger = LogManager.getLogger(ContactsPageStepdefs.class);
    private SoftAssert softAssert = new SoftAssert();
    @Autowired
    private ContactPage contactPage;

    @Then("^In current \"([^\"]*)\" link is \"([^\"]*)\"$")
    public void inCurrentLinkIsAndColorIs(String network, String link) throws Throwable {
        logger.info("Ищем: {}", network);
        softAssert.assertTrue(contactPage.findNetwork(network).isDisplayed(),"Такой Соц.сети нет");
        logger.info("Проверяем ссылку на соц.сеть {}", network);
        String currentLink = contactPage.findNetwork(network).getAttribute("href");
        softAssert.assertEquals(currentLink,link, "Неверная ссылка на соц.сеть");
        softAssert.assertAll();
        throw new PendingException();
    }
}
