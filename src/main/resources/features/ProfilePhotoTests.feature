@All
@ProfilePhoto
Feature: Check add photo
  Background: Open main page Otus
    Given I open main page
    Then I'am on URL "https://otus.ru/"
    When I login with "tokio9507@gmail.com" and "tokio9507"
    And I go to profile
    Then I should see "TatyanaTest"

  Scenario: Check add photo to profile
    When I upload photo to profile
    And I click to choose button
    Then I should not see empty avatar