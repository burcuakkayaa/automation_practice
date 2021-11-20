Feature: Automation Practice Features

  @chrome
  Scenario: Create an account
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

