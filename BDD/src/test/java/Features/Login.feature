Feature: Login

  Scenario Outline: Login successful
    Given a user is on the home page
    When  a user navigates to the Login page using "<URL>"
    And a user enter "<username>" and "<password>"
    And a user clicks the login button
    Then a user is logged in successfully

    Examples:
    |URL|username|password|
    | http://adactinhotelapp.com/index.php  |  Teddymokebe      |  0W3863    |





