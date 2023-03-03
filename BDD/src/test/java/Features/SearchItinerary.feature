Feature:Search Itinerary

  Background:  Login successful

    Given a user is on the home page
    When  a user navigates to the Login page using "https://adactinhotelapp.com/"
    And a user enter "Teddymokebe" and "0W3863"
    And a user clicks the login button
    Then a user is logged in successfully

  Scenario: Search itinerary
#    Given user is on book a hotel page
    When user searches for the desired hotel
    And user enter "Teddy" , "Mokebe" , "2A Harrison", "1111111111111111" , "VISA",  "123"
    And a user copies the order number and paste it on the search hotel
    And a user clicks on Go for search
    Then the hotel search with order number is successful


