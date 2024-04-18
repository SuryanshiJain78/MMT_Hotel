#Scenario 1
#Created By: Suryanshi Jain
#Verified By: Deepali Dhole
#Reviewed By:
#Description:
Feature: Hotel Booking Functionalities

  Background: 
    Given user is on homepage of Make My Trip Website
    When user clicks on the hotels section

  @Scenario1
  Scenario Outline: User searches for hotels
    And User enters details "<Location>", "<Checkin>", "<Checkout>" & "<Rooms_Guest>"
    And click on Apply button
    And click on Search button
    Then relevant hotel options matching the search criteria are displayed
    Examples: 
      | Location | Checkin       | Checkout      | Rooms_Guests |
      | Delhi    | 24,April 2024 | 25,April 2024 | 1, 2, 0      |

  #-------------------------------------------------------------------------------------------------------------------------------
  #Scenario 2
  #Created By: Suryanshi Jain
  #Verified By: Deepali Dhole
  #Reviewed By:
  #Description:
  @Scenario2
  Scenario: User filter hotel search results
    When user has preformed a hotel search
    And user applies filters such as user rating, star category, property type and room amenities etc.
    Then search results are updated to reflect the applied filters

  #-------------------------------------------------------------------------------------------------------------------------------
  #Scenario 3
  #Created By: Suryanshi Jain
  #Verified By: Deepali Dhole
  #Reviewed By:
  #Description:
  @Scenario3
  Scenario: To verify Group Deals functionality of Hotel option
    When user clicks on Group Deals
    And User enter details
      | Location | Checkin       | Checkout      | Rooms_Guests |
      | Delhi    | 24,April 2024 | 25,April 2024 | 5, 10, 0     |
    And click on apply
    And click on Get Me Best Prices button
    Then relevant properties with group deals are displayed

  #-------------------------------------------------------------------------------------------------------------------------------
  #Scenario 4
  #Created By: Suryanshi Jain
  #Verified By: Deepali Dhole
  #Reviewed By:
  #Description:
  @Scenario4
  Scenario: To check Currency change functionality
    When user has performed a hotel search
    And User clicks on currency dropdown
    And Selects the required currency
    Then The currency of the hotel price should change accordingly
  #------------------------------------------------------------------------------------------------------------------------------ 
  #Scenario 5
  #Created By: Suryanshi Jain
  #Verified By: Deepali Dhole
  #Reviewed By:
  #Description:
  @Scenario5
  Scenario: To verify that in suggested list "City/Location/Area" should display name according to the first initial
    And User clicks on location search bar
    And Enter the initial letter of city
    Then It should display all the City names Starting with first letter