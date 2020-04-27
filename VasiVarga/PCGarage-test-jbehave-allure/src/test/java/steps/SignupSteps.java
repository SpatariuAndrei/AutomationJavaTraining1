package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;
import pageObjects.PcGarageHomePage;
import utils.SharedData;

import java.io.IOException;

public class SignupSteps extends BaseSteps {

    SharedData sharedData;
    public SignupSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData=sharedData;
    }

    @Given("I go to PCGarage home page")
    public void givenIGoToPcgarageHomePage() {
        sharedData.pcGarageHomePage = new PcGarageHomePage(sharedData);
        sharedData.pcGarageHomePage.acceptCookies();
    }

    @When("I go to My account")
    public void whenIGoToMyAccount() {
        sharedData.pcGarageLoginSignUpPage = sharedData.pcGarageHomePage.goToMyAccount();
    }

    @When("I sign up")
    public void whenISignUp() throws IOException {
        sharedData.pcGarageLoginSignUpPage.signUp();
    }

    @Then("I get an error message")
    public void thenIGetAnErrorMessage() {
        Assert.assertTrue(sharedData.pcGarageLoginSignUpPage.isErrorTextDisplayed());
    }
}
