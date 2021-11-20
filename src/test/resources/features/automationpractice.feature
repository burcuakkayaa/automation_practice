Feature: Automation Practice Features

@chrome
Scenario: Create an account
  Given user is on main page
  When user clicks sign in option
  Then user should see on create account page
  When user enters email to send email textbox
  And user clicks create an account button
  Then user should see personal information form
  When user selects title "Mrs."
#  And user enters a name "burcu" to personal information area
#  And user enters a surname "akkaya"
#  And user enters an email "burkjds@gmail.com"
#  And user enters a password "123455"
#  And user selects dates of birth "13.04.1996"
#  And user enters a company name  "kkffsd" to address information area
#  And user enters an address "istanbul turkiye"
#  And user enters a city "ist"
#  And user selects 2. state
#  And user enters a zip number
#  And user selects a country "United States"
#  And user enters a mobile phone
#  And user enters an address alias for future reference
#  And user clicks register button
#  Then user should see account categories on my account page

