Feature: SauceDemo Checkout
  User is able to log in with correct credentials. Error message is shown if wrong/empty data is provided.
  User is able to add item ot cart, check if item is in cart, go to Checkout and enter name/surname/postal code.
  User is able to go to Checkout overview page, check data, go to Finish page
  and navigate back to first page by clicking 'Back Home'

@browser1
Scenario: User is able to log in with correct credentials
  Given user is navigated to 'https://www.saucedemo.com/'
  Then user enters username 'standard_user' and password 'secret_sauce'
  When user clicks login button
  Then user is successfully logged in
