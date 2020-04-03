@All
@ChangePassword
Feature: Check change password for account

  @ErrorPass
  Scenario: Send too small password
    Given I open main page
    When I login to test account
    And I go to settings
    And I input new "123" to change form
    Then I should see change password error "Введённый пароль слишком короткий. Он должен содержать как минимум 8 символов" message and color is "#960000" on settings page

  @ErrorPass
  Scenario: Send password with digital only
    Given I open main page
    When I login to test account
    And I go to settings
    And I input new "12345678" to change form
    Then I should see change password error "Введённый пароль состоит только из цифр" message and color is "#960000" on settings page

  @ErrorPass
  Scenario: Send different password and password-check
    Given I open main page
    When I login to test account
    And I go to settings
    And I input new password "tokio9508" to change form
    And I input new password-check "tokio9509" to change form
    And I save changes
    Then I should see change password error "Пароли не совпадают" message and color is "#960000" on settings page

  @NewPass
  Scenario: Change to new password
    Given I open main page
    And profile name is profile name is 1
    When I login to test account
    And I go to settings
    And I input new "tokio9508" to change form
    Then I should see change successful message "Пароль успешно изменен"
    When I logout from account
    And I login with "tokio9508" password
    And I go to profile
    Then I should see profile name profile name

  @OldPass
  Scenario: Change to old password
    Given I open main page
    And profile name is profile name is 1
    When I login with "tokio9508" password
    And I go to settings
    And I input new "tokio9507" to change form
    And I logout from account
    And I login to test account
    And I go to profile
    Then I should see profile name profile name
