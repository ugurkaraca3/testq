Feature: Test Searching Owner and add if it is not existing

	Background: To Launch the web site
		Given Launch the web site
		And Click find owners button
		And Hit the search box
		
	Scenario: Searching non-existing user
		When Type "Asdf" in the search box
		And Click find owner button
		Then We should see "has not been found" text
		
	Scenario: Adding owner
		When Hit the "Add Owner" button
		And user enter valid data on the page
		|Fields		|Values		|
		|firstName	|Gözde		|
		|lastName	|Dereli		|
		|address	|Maltepe	|
		|city		|İstanbul	|
		|telephone	|1234567890	|
		And Click Add Owner button
        Then Owner table should be visible
		
	
	