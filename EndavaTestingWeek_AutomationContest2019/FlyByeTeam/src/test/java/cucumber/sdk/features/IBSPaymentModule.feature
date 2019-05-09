Feature:IBS PAYMENT MODULE

  Scenario: [Payment] CARD: M3 Credentials after purchase can be used for M3 Login
    Given User is in Modules View
    And User selects IBS Payment Module
    When User makes IBS credit card purchase
    Then Received MConnect credentials "normalPay" can be used for login