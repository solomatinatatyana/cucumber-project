@All
@Contacts
Feature: Check SocialNetworks
  Background: Open main page Otus
    Given I open main page
    Then I'am on URL "https://otus.ru/"

  Scenario Outline: I check All socialNetworks on Contacts
    When I drillDown to "Контакты"
    Then In current "<network>" link is "<link>"

    Examples:
    |network                  |link                                                      |
    |ВКонтакте                |https://vk.com/club145052891                              |
    |Facebook                 |https://www.facebook.com/otus.ru/                         |
    |OK                       |https://ok.ru/group/54448251797611                        |
    |Дзен                     |https://zen.yandex.ru/id/5bbcbc1ba5bd5400a990e7d9         |
    |YouTube                  |https://www.youtube.com/channel/UCetgtvy93o3i3CvyGXKFU3g  |
    |Канал в Telegram         |https://t.me/Otusjava                                     |
    |Группа в Telegram        |https://t.me/joinchat/              |


