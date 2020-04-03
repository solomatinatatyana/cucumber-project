@All
@LoginProfile
Feature: Login OTUS
  Background: Open main page Otus
    Given I open main page
    And profile name is profile name is 1
    Then I'am on URL "https://otus.ru/"

  @Success
  Scenario: Successful login
    When I login to test account
    And I go to profile
    Then I should see profile name profile name

  @Fail
  Scenario: Login fail
    When I login with "test" password
    Then I should see error "Такая пара логин/пароль не существует" message and color is "#9a0f0f"


