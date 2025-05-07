Feature: User
  As an admin
  I want to see list of user
  So that I can create new user

  Scenario: Get - As an admin I have to be able to get detail user
    Given I set GET api endpoint
    When I send GET HTTP request
    Then I receive valid HTTP response code
    And I receive valid data for detail user

//  Scenario: Post - As an admin I have to be able to create new user
//    Given I set POST api endpoint
//    When I send POST HTTP request
//    Then I receive valid HTTP response code 201
//    And I receive valid data for new user
//    And I use the id for another method

//  Scenario: Put - As an admin I have to be able to update existing user
//    Given I set PUT api endpoint
//    When I send PUT HTTP request
//    Then I receive valid HTTP response code 200
//    And I receive valid data for updated user

//  Scenario: Delete - As and admin I have to be able to delete existing user
//    Given I set DELETE api endpoint
//    When I send Delete HTTP request
//    Then I receive valid HTTP response code 204
