Feature:IBS MODULE

  Scenario: Successful M3 login with given username and password
    Given User is in Modules View
    And User selects IBS Module
    When User makes a successful login
    Then User validates that correct data is displayed