package ru.otus.cucumberproject.stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.asserts.SoftAssert;
import ru.otus.cucumberproject.pagesandblocks.pages.CoursePage;

public class CoursePageStepdefs {
    private static final Logger logger = LogManager.getLogger(CoursePageStepdefs.class);
    private SoftAssert softAssert = new SoftAssert();

    @Autowired
    private CoursePage coursePage;

    private int allCoursesCount;
    private int coursesInDevelopmentCount;

    @And("^I get count \"([^\"]*)\"$")
    public void iGetCount(String type){
        ((JavascriptExecutor) coursePage.driver).executeScript("window.scrollBy(0,5000)");
        if(type.equals("all courses")){
            allCoursesCount = coursePage.getAllCoursesCount();
            logger.info("Всего курсов: {}", allCoursesCount);
        }else {
            coursesInDevelopmentCount = coursePage.getCoursesInDevelopmentCount();
            logger.info("В разработке курсов: {}", coursesInDevelopmentCount);
        }
    }

    @Then("^I check expected count \"([^\"]*)\" and \"([^\"]*)\" in \"([^\"]*)\"$")
    public void iCheckExpectedCountAnd(int arg0, int arg1, String type) throws Throwable {
        softAssert.assertEquals(allCoursesCount,arg0, "отображается всего неверное количество курсов в разделе [" + type +"]");
        softAssert.assertEquals(coursesInDevelopmentCount,arg1, "отображается неверное количество курсов в разработке в разделе [" + type +"]");
        softAssert.assertAll();
        throw new PendingException();
    }
}
