Feature: Safety Login feature

	In order to ensure Login functionality works,
	I want to run the cucumber test to verify it is working

Scenario:Login Functionality


	Given user opens chrome driver
	Given user navigates to https://safety.kuvrr.com/
	When title of the login page is Safety Kuvrr
	Then user enters email "lackorg@mailinator.com" and password "12345678"
	Then user click on continue button
	And user is on home Page