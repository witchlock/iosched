@sessions
Feature: View All Sessions
    How user see the session list view

Scenario: View all Google IO sessions
    Given the Google account is linked to Google IO application
    When the Google IO application is launched
    Then I should see all the sessions available