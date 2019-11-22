package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import pages.HomePage;
import pages.LoginPage;
import steps.setup.BaseSteps;
import utilities.SharedData;

import static java.lang.Thread.sleep;

public class LoginSteps extends BaseSteps {

    private HomePage homePage;
    private LoginPage loginPage;

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
        waitFor(1000);
    }

    @Given("I navigate to login page")
    public void givenINavigateToLoginPage() {
        loginPage = new LoginPage(sharedData.driver);
        homePage.navigateToLoginPage();
    }

    @Then("I set email field")
    public void thenISetEmailField() {
        loginPage.enterUserEmail();
    }

    @Then("I press Continua")
    public void thenIPressContinua() {
        loginPage.clickNext();
    }

    @Then("I set Introdu parola contului tau eMag filed")
    public void thenISetIntroduParolaContuluiTauEmagFiled() {
        loginPage.enterUserPassword();
    }

    @Then("I press Continua to enter in home page")
    public void thenIPressContinuaToEnterInHomePage() {
        loginPage.clickNext();
    }
}
