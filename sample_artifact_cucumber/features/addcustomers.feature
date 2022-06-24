Feature: addcustomer

  Scenario: Adding a Customer
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then user can view dashboard
    When User click on customer menu
    And User click on customer menuitem
    And User click on add button
    Then user can view add customer page
    When user enters customer info
    And Click on save
    Then user can view confirmation msg "The new customer has been added successfully."
    And close browser

  Scenario: Search a customer by email
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then user can view dashboard
    When User click on customer menu
    And User click on customer menuitem
    When Enter customer email
    Then User click on search button
    When User find email in search table
    And close browser

  Scenario: Search a customer by name
    Given User Launch Chrome Browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then user can view dashboard
    When User click on customer menu
    And User click on customer menuitem
    When Enter customer firstname
    When Enter customer lastname
    Then User click on search button
    When User find name in search table
    And close browser
