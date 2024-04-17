Feature: Test orange HRm application

  Scenario: Test Browser Functionality
    Given user enter "chrome" browser and open login url

  Scenario: Testion login functionality
    When user enter valid creditinal and click on login button
    Then user validate Title
    And user validate url

  Scenario Outline: Pim Page Functionality
    When user Click on pim page
    When user validate url by using url
      | pim |
    And user click on addemployee link an d enter "<firstname>","<lastnaem>" and click on save button
    And capture the employee id and click on employee list
    And enter employee id in employee id and click on search button
    And select the search employee and click on delete
    Then validate user delete or not

    Examples: 
      | firstname | lastname |
      | Hari      | Nomula   |
      | Maya      | Bathula  |
      | Rajan     | Bingi    |
      | Vidya     | Bhima    |
      | Chandan   | Sha      |
