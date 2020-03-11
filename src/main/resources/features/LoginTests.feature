@LoginProfile
Feature: Login OTUS
  Background: Open main page Otus
    Given I open main page
    Then I'am on URL "https://otus.ru/"

  @Success
  Scenario: Successful login
    When I login with "tokio9507@gmail.com" and "tokio9507"
    And I go to profile
    Then I should see "TatyanaTest"

  @Fail
  Scenario: Login fail
    When I login with "tokio9507@gmail.com" and "test"
    Then I should see error "Такая пара логин/пароль не существует" message and color is "#9a0f0f"


