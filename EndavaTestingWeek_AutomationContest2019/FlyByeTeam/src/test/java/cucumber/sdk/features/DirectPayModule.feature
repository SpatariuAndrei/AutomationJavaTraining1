Feature:DIRECT PAYMENT MODULE

  Scenario: DIRECT PAY: M3 Credentials after purchase can be used for M3 Login
    Given User is in Modules View
    And User selects Direct Pay Module
    When User pays with Direct Pay
    Then Received MConnect credentials "directPay" can be used for login