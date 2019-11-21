package steps.functional.login;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import utilities.SharedData;

import static properties.PropertiesKeys.EMAG_EMAIL_ADDRESS;

public class LoginSteps extends Steps {
    private SharedData share;

    public LoginSteps(SharedData share) {
        this.share = share;
    }

    @Given("I navigate to login page")
    public void givenINavigateToLoginPage() {
        share.loginPage = share.homePage.navigateToLoginPage();
    }

    @Then("I set $email address field")
    public void thenISetEmailAddressField(String email) {
        String emailAddress = PropertiesConfig.getProperty(EMAG_EMAIL_ADDRESS);
        share.loginPage.setLoginInputField(email, emailAddress);
    }

    @Then("I press $nextButton button")
    public void thenIPressContinuaButton(String nextButton) {
        share.loginPage.clickContinueValidPassword(nextButton);
    }
}
