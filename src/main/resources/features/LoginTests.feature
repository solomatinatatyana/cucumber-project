Feature: Login OTUS
@LoginProfile

  Scenario: Successful login
    Given I open main page
    #When I'am on URL "https://otus.ru/"
    When I login with "tokio9507@mail.ru" and "TEST"
    #Then I'am on the "My profile" page on URL ""

  Scenario: Login fail
    When I login with "Test" and "test"
    #Then I should see "<warning>" message


