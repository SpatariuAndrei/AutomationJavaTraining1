package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.FormAuthenticationPage;
import pages.HomePage;
import pages.SecureAreaPage;


public class FormAuthenticationSteps extends Steps {

    private WebDriver driver;
    private HomePage homePage;
    private FormAuthenticationPage formAuthenticationPage;
    private SecureAreaPage secureAreaPage;

    @Given("I open form authentication page")
    public void openingFormAuthenticationPage() {
        formAuthenticationPage = OpenDemoLinkSteps.homePage.goToFormAuthenticationPage();
    }

    @When("I enter username $username and password $password")
    public void enteringUsernameAndPassword(String username, String password) {
        formAuthenticationPage.login(username, password);
        secureAreaPage = formAuthenticationPage.goToSecureAreaPage();
    }

    @Then("I should see $message on Secure Area page")
    public void verifyingMessageOnSecureaAreaPage(String message) {
        Assert.assertTrue("Incorrect message on secured area page", secureAreaPage.verifyResponse(message));
    }

    @BeforeStories
    public void beforeStories() {
        System.out.println("Hello, I am running some stories");
    }

    @AfterStories
    public void afterStory() {
        System.out.println("Time to quit, bye bye");
        OpenDemoLinkSteps.driver.quit();
    }
}
