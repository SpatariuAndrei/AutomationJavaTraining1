package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserHomePage;
import steps.setup.BaseSteps;
import utilities.SharedData;

import static java.lang.Thread.sleep;
import static junit.framework.TestCase.assertTrue;

public class LoginSteps extends BaseSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private UserHomePage userHomePage;

    public LoginSteps(SharedData sharedData) {
        super(sharedData);
    }

    private void waitFor(int timeout) {
        try {
            sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Given("I open eMag home page")
    public void givenIOpenEmagHomePage() {
        homePage = new HomePage(sharedData.driver);
        homePage.get();
        waitFor(2000);
    }

    @Given("I navigate to login page")
    public void givenINavigateToLoginPage() {
        loginPage = homePage.navigateToLoginPage();
    }

    @Given("I set email field")
    public void thenISetEmailField() {
        loginPage.enterUserEmail();
    }

    @Given("I press Continua")
    public void thenIPressContinua() {
        loginPage.clickNext();
    }

    @Given("I set Introdu parola contului tau eMag filed")
    public void thenISetIntroduParolaContuluiTauEmagFiled() {
        loginPage.enterUserPassword();
    }

    @When("I press Continua to enter in home page")
    public void thenIPressContinuaToEnterInHomePage() {
        loginPage.clickNext();
    }

    @Then("I verify that user name $name is displayed")
    public void thenIVerifyThatUserNameIsDisplayed(String expectedName) {
        userHomePage = new UserHomePage(sharedData.driver);
        String actualValue = userHomePage.getUser();
        assertTrue(actualValue.contains(expectedName));
    }
}
