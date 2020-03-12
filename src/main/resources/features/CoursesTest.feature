@All
@Courses
Feature: Check count courses for All categories - All count and in development count
  Background: Open main page Otus
    Given I open main page
    Then I'am on URL "https://otus.ru/"

  Scenario Outline: Check courses for All categories
    When I drillDown to "<category>"
    And I get count "all courses"
    And I get count "courses in development"
    Then I check expected count "<all count courses>" and "<courses in development>"

    Examples:
    |category | all count courses| courses in development|
    |Программирование           |39          |1|
    |Инфраструктура             |21          |4|
    |Информационная безопасность|8           |1|
    |Data Science               |10          |2|
    |Управление                 |5           |0|
    |Тестирование               |5           |2|
