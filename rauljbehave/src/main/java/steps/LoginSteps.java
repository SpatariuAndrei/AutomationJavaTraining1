package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utilities.SharedData;

import static junit.framework.TestCase.assertTrue;

public class LoginSteps extends Steps {

    private SharedData sharedData;

    public LoginSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I navigate to login page")
    public void givenINavigateToLoginPage() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
    }

    @Given("I set email field")
    public void thenISetEmailField() {
        sharedData.loginPage.enterUserEmail();
    }

    @Given("I press Continua")
    public void thenIPressContinua() {
        sharedData.loginPage.clickNext();
    }

    @Given("I set Introdu parola contului tau eMag field")
    public void thenISetPasswordField() {
        sharedData.loginPage.enterUserPassword();
    }

    @When("I press Continua to enter in home page")
    public void thenIPressContinuaToEnterInHomePage() {
        sharedData.userHomePage = sharedData.loginPage.clickNextValidPassword();
    }

    @Then("I verify that user name $name is displayed")
    public void thenIVerifyThatUserNameIsDisplayed(String expectedName) {
        String actualValue = sharedData.userHomePage.getUser();
        assertTrue(actualValue.contains(expectedName));
    }
}
