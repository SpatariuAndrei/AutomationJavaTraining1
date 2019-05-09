package cucumber.sdk.tests;

import api.apps.sdk.inflight.endava.com.direct.pay.module.DirectPayManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class DirectPayModuleSteps {
    @And("^User selects Direct Pay Module$")
    public void userSelectsDirectPayModule() throws FileNotFoundException {
        String username = runningSetup().getUsermail();
        String password = runningSetup().getUserpassword();
        DirectPayManager directPayManager = new DirectPayManager();
        directPayManager.startModule();
        directPayManager.fetchTariffs(username, password);
    }

    @When("^User pays with Direct Pay$")
    public void userPaysWithDirectPay() throws FileNotFoundException {
        DirectPayManager directPayManager = new DirectPayManager();
        directPayManager.creditCardFlow();
    }
}
