package cucumber.sdk.tests;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class IBSModuleSteps {
    @And("^User selects IBS Module$")
    public void userSelectsIBSModule() throws FileNotFoundException {
        IBSManager ibsManager = new IBSManager();
        ibsManager.startModule();
    }

    @When("^User makes a successful login$")
    public void userMakesASuccessfulLogin() throws FileNotFoundException {
        String email = runningSetup().getUsermail();
        String password = runningSetup().getUserpassword();
        IBSManager ibsManager = new IBSManager();
        ibsManager.successfullLogin(email, password);
    }

    @Then("^User validates that correct data is displayed$")
    public void userValidatesThatCorrectDataIsDisplayed() throws FileNotFoundException {
        IBSManager ibsManager = new IBSManager();
        String fname = "Mihai";
        ibsManager.validateSuccessullLogin(fname);
    }
}
