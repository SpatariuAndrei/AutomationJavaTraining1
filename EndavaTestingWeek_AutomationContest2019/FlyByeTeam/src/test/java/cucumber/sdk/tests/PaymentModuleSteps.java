package cucumber.sdk.tests;

import api.apps.sdk.inflight.endava.com.payment.module.PaymentManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class PaymentModuleSteps {

    @Given("^User is in Modules View$")
    public void userIsInModulesView() {
    }

    @And("^User selects Payment Module$")
    public void userSelectsPaymentModule() throws FileNotFoundException {
        PaymentManager paymentManager = new PaymentManager();
        paymentManager.startModule();
        paymentManager.fetchTariffs();
    }

    @When("^User makes credit card purchase$")
    public void userMakesCreditCardPurchase() throws Exception {
        String fname = "Mihai";
        String lname = "Lucian";
        String country = "DE";
        String email = runningSetup().getUsermail();
        String card = "4111111111111111";
        String csv = "213";
        PaymentManager paymentManager = new PaymentManager();
        paymentManager.creditCardFlow(fname, lname, country, email, card, csv);
    }

    @Then("^Received MConnect credentials \"([^\"]*)\" can be used for login$")
    public void receivedMConnectCredentialsCanBeUsedForLogin(String arg0) throws Throwable {
        PaymentManager paymentManager = new PaymentManager();
        paymentManager.validateM3LoginWithReceivedCredentials(arg0);
    }
}
