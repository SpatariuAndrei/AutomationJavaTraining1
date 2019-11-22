package steps;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import pages.EmagHomePage;
import pages.LoginPage;
import utils.Helper;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class EmagLoginSteps {

    public static WebDriver driver;
    public static EmagHomePage homePage;
    public LoginPage loginPage;
    private Helper helper = new Helper(driver);
    private final String path = "/src/main/resources/chromedriver.exe";

    @Given("I open a browser")
    public void openingABrowser() throws IOException {
        driver = DriverInstance.getDriver();
        homePage = new EmagHomePage(driver);
    }

    @When("I enter $url and hit the enter key")
    public void enteringAnUrl(String url) {
        driver.get(url);
    }

    @Then("$title is displayed")
    public void titleIsDisplayed(String title) {
        assertEquals(title, driver.getTitle(), "Incorrect title");
    }

    @When("When I go to My account")
    public void goToMyAccount() {
        homePage.moveOverMyAccount();
    }

    @When("I click on Intra in cont")
    public void clickOnAccount() {
        loginPage = homePage.clickOnMyAccount();
    }

    @Then("I should be redirected to Login form page where I enter my email $email")
    public void viewLoginPage(String email) {
        loginPage.enterEmail(email);
    }

    @When("I click on continue")
    public void clickOnContinue() {
        loginPage.clickOnContinue();
    }

    @When("I enter my password")
    public void enterPassord() {
        loginPage.enterPassword("televizor40A)");
    }

    @Then("After continue, I should see home page")
    public void continueAndReturnHomePage()  {
        loginPage.clickOnContinue2();
    }

    @When("I go to my profile on favorite products")
    public void goToProfilePicture() throws InterruptedException {
        homePage.clickOnProfile();
    }

    @Then("I should see $name as username")
    public void verifyStatus(String name) {
        // assertEquals(homePage.getStatus(), name, "Not logged in");
    }
}
