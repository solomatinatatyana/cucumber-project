@All
@ProfilePhoto
Feature: Check add photo
  Background: Open main page Otus
    Given I open main page
    And profile name is profile name is 2
    Then I'am on URL "https://otus.ru/"
    When I login to test2 account
    And I go to profile
    Then I should see profile name profile name

  Scenario: Check add photo to profile
    When I upload photo to profile
    And I click to choose button
    Then I should not see empty avatar