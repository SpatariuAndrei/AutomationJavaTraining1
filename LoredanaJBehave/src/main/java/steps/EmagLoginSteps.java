package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utils.DataFromPropertyFile;
import utils.Helper;
import utils.SharedData;

import static org.testng.Assert.assertEquals;

public class EmagLoginSteps extends Steps {


    private SharedData sharedData;
    private Helper helper;
    public EmagLoginSteps(SharedData sharedData) {
        this.sharedData = sharedData;
        helper = new Helper(sharedData);
    }


    @Given("I navigate to login page")
    public void givenINavigateToLoginPage() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
    }

    @When("I set $email address field")
    public void thenISetEmailAddressField(String email) {
        String emailAddress = DataFromPropertyFile.getEmail();
        sharedData.loginPage.enterEmail(emailAddress);
    }

    @When("I press $nextButton button")
    public void thenIPressContinuaButton(String nextButton) {
        sharedData.loginPage.clickOnContinue();
    }

    @When("I set $password field")
    public void thenISetPasswordField(String password) {
        String passwordValue = DataFromPropertyFile.getPassword();
        sharedData.loginPage.enterPassword(passwordValue);
    }

    @When("I press $continua button after valid password")
    public void thenIPressContinuaButtonAfterValidPassword(String continua) {
        sharedData.homePage = sharedData.loginPage.clickOnContinue2();
    }

    @When("I open user menu")
    public void openUserMenu() throws InterruptedException {
        sharedData.homePage.moveOverProfilePicture();
        sharedData.homePage.clickOnProfile();
    }

    @Then("I verify that user name $name is displayed")
    public void verifyName(String name) {
        assertEquals(sharedData.homePage.getStatus(), name, "Not logged in");
    }
}
