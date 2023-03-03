Feature: Book a Hotel

  Background:  Login successful

    Given a user is on the home page
    When  a user navigates to the Login page using "https://adactinhotelapp.com/"
    And a user enter "Teddymokebe" and "0W3863"
    And a user clicks the login button
    Then a user is logged in successfully


  Scenario Outline: Search Successful
#    Given user is on book a hotel page
    When user searches for the desired hotel
   And user enter "<First Name>" , "<Last Name>" , "<Billing Address>", "<Credit card number>" , "<Credit card type>",  "<Cvv number>"
    Then hotel booked successfully

    Examples:
    |First Name| Last Name| Billing Address| Credit card number| Credit card type | Cvv number|
    |Teddy     |Mokebe    |2A Harrison     |1111111111111111   |VISA             |123        |

  Scenario Outline: Search unsuccessful
#    Given user is on book a hotel page
    When user searches for the desired hotel
    And user enter "<First Name>" , "<Last Name>" , "<Billing Address>", "<Credit card number>" , "<Credit card type>",  "<Cvv number>"
    Then hotel booked unsuccessfully

    Examples:
      |First Name| Last Name| Billing Address| Credit card number| Credit card type | Cvv number|
      |Teddy     |Mokebe    |2A Harrison     |111111  |VIS          |123        |




