Feature: Login page feature

  Scenario: Login page title
	Given user is on login page
	And user gets the title of the page
  # Then page title should be "Customer Login Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"
	Then page title should be "Login - My Store"

  Scenario: Forgot Password link
	Given user is on login page
	Then forgot your password link should be displayed

  Scenario: Login with correct credentials
	Given user is on login page
	When user enters username "khandelotevikas@gmail.com"
	And user enters password "Vikas@358"
	And user clicks on Login button
	Then user gets the title of the page
   # And page title should be "My Account Magento Commerce - website to practice selenium | demo website for automation testing | selenium practice sites"
	And page title should be "My account - My Store"