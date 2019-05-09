package cucumber.sdk.tests;

import api.apps.sdk.inflight.endava.com.ibs.payment.module.IBSPaymentManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class IBSPaymentModuleSteps {
    @And("^User selects IBS Payment Module$")
    public void userSelectsIBSPaymentModule() throws FileNotFoundException {
        String email = runningSetup().getUsermail();
        String password = runningSetup().getUserpassword();
        IBSPaymentManager ibsPaymentManager = new IBSPaymentManager();
        ibsPaymentManager.startModule();
        ibsPaymentManager.fetchTariffs(email, password);
    }

    @When("^User makes IBS credit card purchase$")
    public void userMakesIBSCreditCardPurchase() throws Exception {
        String card = "4111111111111111";
        String csv = "213";
        IBSPaymentManager ibsPaymentManager = new IBSPaymentManager();
        ibsPaymentManager.creditCardFlow(card, csv);
    }
}
