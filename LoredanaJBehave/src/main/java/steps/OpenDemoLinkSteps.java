package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.Helper;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class OpenDemoLinkSteps extends Steps {

    public static WebDriver driver;
    public static HomePage homePage;
    private Helper helper = new Helper(driver);
    private final String path = "/src/main/resources/chromedriver.exe";

    @Given("I open a browser")
    public void openingABrowser() throws IOException {
        driver = helper.instantiateChromeDriver();
        homePage = new HomePage(driver);
    }

    @When("I enter $url and hit the enter key")
    public void enteringAnUrl(String url) {
        driver.get(url);
    }

    @Then("$title is displayed")
    public void titleIsDisplayed(String title) {
        assertEquals(title, driver.getTitle(), "Incorrect title");
    }
}