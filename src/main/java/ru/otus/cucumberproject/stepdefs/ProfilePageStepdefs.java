package ru.otus.cucumberproject.stepdefs;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.cucumberproject.pagesandblocks.pages.ProfilePage;

public class ProfilePageStepdefs {
    @Autowired
    private ProfilePage profilePage;

    /*@When("I go to profile")
    public void goToProfile(){
        profilePage.goToMyProfile();
        profilePage.goToBiography();
    }*/

    @Then("I should see \"(.*)\"")
    public void check(String something){
        Assert.assertEquals(profilePage.firstNameTextInput.getAttribute("value"),something);
    }
}
