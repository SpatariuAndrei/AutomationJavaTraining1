package steps;

import jbehavepages.FormAuthenticationPageJBehave;
import jbehavepages.SecureAreaPageJBehave;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import utils.DriverInitializerJBehave;

import static org.junit.Assert.assertTrue;

public class FormAuthenticationPageSteps {

    private FormAuthenticationPageJBehave formAuthenticationPageJBehave;
    private SecureAreaPageJBehave secureAreaPageJBehave;
    private WebDriver driver;

    @Given("I open a browser")
    public void givenIOpenABrowser() {
        driver = new DriverInitializerJBehave(driver).init();
        formAuthenticationPageJBehave = new FormAuthenticationPageJBehave(driver);
    }

    @Given("I search for url page")
    public void openloginPage() {
        formAuthenticationPageJBehave.goToLoginPage();
    }

    @When("I enter username and password")
    public void enterCredentials() {
        formAuthenticationPageJBehave.setUsername();
        formAuthenticationPageJBehave.setPassword();
        formAuthenticationPageJBehave.clickLoginButton();
    }

    @Then("then a new Secure Area page will be open")
    public void openNewPage() {
        secureAreaPageJBehave = new SecureAreaPageJBehave(driver);
        assertTrue("Alert text is incorrect",
                secureAreaPageJBehave.getAlertText().contains("You logged into a secure area!"));
    }

    @AfterStories
    public void tearDown() {
        driver.quit();
    }

}
