Feature: Automation Practice Features

  Background: Create an account
    Given user is on main page
    When user clicks sign in option
    Then user should see on create account page
    When user enters an email to send email textbox
    And user clicks create an account button
    Then user should see personal information form
    When user selects title "Mrs."
    And user enters a name
    And user enters a surname
    And user checks email has already entered
    And user enters a password
    And user selects dates of birth "13.04.1996"
    And user checks name has already entered to address form area
    And user checks surname has already entered to address form area
    And user enters an address
    And user enters a city
    And user selects 2. state
    And user enters a zip code
    And user selects a country
    And user enters a mobile phone
    And user enters an address alias for future reference
    And user clicks register button
    Then user should see account categories on my account page
    And user should see account has already signed in

  @chrome
  Scenario: Adding product to Basket
    When user select "dresses" category
    And user clicks "Summer Dresses" category
    Then user is on category page
    When user enters "summer" to search area
    And user selects 1. product on product list
    Then user should see product successfully added window
    When user copies name of product on window
    And user copies quantity of product on window
    And user copies price of product on window
    And user closes to window
    And user clicks card menu
    And user clicks check out on card menu
    Then user is on order page
    And user should see name of product is same between category and order page
    And user should see quantity of product is same between category and order page
    And user should see price of product is same between category and order page
    When copies total price of products on order page
    When user clicks proceed to checkout button on order page
    Then user is on address menu on order page
    When user clicks proceed to checkout button on order page
    Then user is on shipping menu on order page
    When user clicks the terms of the service checkbox
    And user clicks proceed to checkout button on order page
    Then user is on payment menu on order page
    When user selects "bank wire" as payment method
    Then user is on order bank wire summary menu on order page
    When user clicks confirm button
    Then user should see order confirmation menu
    And user should see successful message "Your order on My Store is complete."
    When user clicks account title
    Then user should see account categories on my account page
    When user clicks "Order history and details" to category
    Then user is on order history menu on account page
    And user checks total price on history menu





