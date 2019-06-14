Feature:FAILING TESTS

  Scenario: Fail a test to generate report
    Given User is in Modules View
    And User selects IBS Module
    When User makes a successful login
    And User validates that correct data is displayed
    Then Received MConnect credentials "normalPay" can be used for login