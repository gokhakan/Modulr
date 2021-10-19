
Feature: User Verification


  Scenario: verify valid credential login
    Given I am on Modulr homepage
    When I use valid username and password
    Then I should be able to login succesfully



  Scenario: verify invalid credentials
      Given I am on Modulr homepage
      When I use invalid username and password
      Then I shouldn't be able to login

  @wip
  Scenario: Creating anew account
      Given I am on the home page
      When I click on Add new account
      Then I should be on Accounts page