@Login
Feature: Sign In
  As a customer of the company
  I want to login to application with my credentails
  In order to use the application features.
  
    Background: User navigates to Application URL
    Given User is on Login page URL "https://kundenbereich.check24.de/user/login.html"
    Then I should see Log In Page

  @sanity
  Scenario: Sign In with valid credentials
    When I enter username as "anil.kundeti@gmail.com"
    And I enter password as "KAK@123#"
    And click on login button
    Then I sould see application homepage

  @sanity
  Scenario Outline: Sign In with valid credentials
    When I enter username as "<userName>"
    And I enter password as "<password>"
    And click on login button
    Then I sould see application homepage

    Examples: 
      | userName | password |
      | anil.kundeti@gmail.com | KAK@123#|
      | srividyakundeti@gmx.de  |Tanusri@123#|
     