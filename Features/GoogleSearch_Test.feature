Feature: Search functionality

Scenario Outline: Search for a String and verify if result is retrieved
	Given User is on Google Search Landing Page
	When User enters a <search_string>
	And clicks on search button
	Then <result> is displayed
	
Scenarios:
| search_string   			| result							|
| Cucumber Test Framework   | Cucumber 							|
| Selenium 					| Selenium - Web Browser Automation |
	
Scenario: Google Search
    Given the following search strings:
	| Cucumber Test Framework   | Cucumber 							|
	| Selenium 					| Selenium - Web Browser Automation |