package steps.functional.login;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import properties.PropertiesConfig;
import uimappers.components.forms.CheckboxStatus;
import utilities.SharedData;

import static properties.PropertiesKeys.EMAG_EMAIL_ADDRESS;
import static properties.PropertiesKeys.EMAG_PASSWORD;

public class LoginSteps extends Steps {
    private SharedData sharedData;

    public LoginSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I navigate to login page")
    public void givenINavigateToLoginPage() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
    }

    @When("I set $email address field")
    public void thenISetEmailAddressField(String email) {
        String emailAddress = PropertiesConfig.getProperty(EMAG_EMAIL_ADDRESS);
        sharedData.loginPage.setLoginInputField(email, emailAddress);
    }

    @When("I press $nextButton button")
    public void thenIPressContinuaButton(String nextButton) {
        sharedData.userHomePage = sharedData.loginPage.clickContinueValidPassword(nextButton);
    }

    @When("I set $password field")
    public void thenISetPasswordField(String password) {
        String passwordValue = PropertiesConfig.getProperty(EMAG_PASSWORD);
        sharedData.loginPage.setLoginInputField(password, passwordValue);
    }

    @When("I press $continua button after valid password")
    public void thenIPressContinuaButtonAfterValidPassword(String continua) {
        sharedData.userHomePage = sharedData.loginPage.clickContinueValidPassword(continua);
    }

    @When("I $status box $keep_email option")
    public void thenIUncheckBoxKeepemailOption(CheckboxStatus status, String checkboxId) {
        sharedData.loginPage.checkboxStatusChange(status, checkboxId);
    }

    @When("I set $password field to $invalidPassword")
    public void whenISetPasswordFieldToWrongpass(String password, String wrongPassword) {
        sharedData.loginPage.setLoginInputField(password, wrongPassword);
    }

    @When("I press $continua button after invalid password")
    public void whenIPressContinuaButtonAfterInvalidPassword(String continua) {
        sharedData.loginPage.clickContinueInvalidPassword(continua);
    }

    @Then("I verify that $errorMessahe error message appears")
    public void thenIVerifyThatAiIntrodusGresitParolaSauAdresaDeEmailTeRogCompleteazaDinNouErrorMessageAppears(String errorMessage) {
     Assert.assertTrue(sharedData.loginPage.verifyIfErrorMessageAppears(errorMessage));
    }

    @When("I click on $socialMediaPlatform login option")
    public void whenIClickOnGoogleLoginOption(String socialMedia) {
        sharedData.loginPage.clickOnSocialPlatformLink(socialMedia);
    }
}
