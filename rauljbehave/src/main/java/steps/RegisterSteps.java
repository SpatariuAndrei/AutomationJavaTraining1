package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import pages.UserHomePage;
import utilities.SharedData;

public class RegisterSteps extends Steps {

    private SharedData sharedData;

    public RegisterSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I navigate to my personal data page")
    public void whenINavigateToDataPage() {
        sharedData.personalDataPage = sharedData.homePage.goToPersonalDataPage();
    }

    @When("I stream my test data: $path")
    public void whenIStreamMyTestData(String path) {
        sharedData.personalDataPage.populateMap();
    }

    @When("I populate my account with data")
    public void whenIPopulateAccount() {

    }

    @Then("I check that data was populated correctly")
    public void thenICheckData() {

    }
}
