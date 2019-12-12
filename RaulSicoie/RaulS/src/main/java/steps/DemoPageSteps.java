package steps;

import jbehavepages.HomePageJBehave;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import utils.DriverInitializerJBehave;

import static org.junit.Assert.assertEquals;

public class DemoPageSteps extends Steps {

    private static WebDriver driver;
    private HomePageJBehave homePageJBehave;

    @Given("I open a browser")
    public void openingBrowser() {
        driver = new DriverInitializerJBehave(driver).init();
        homePageJBehave = new HomePageJBehave(driver);
    }

    @When("I enter TheInternet and hit enter key")
    public void enteringUrl() {
        homePageJBehave.goToBasePage();
    }

    @Then("$title is displayed")
    public void lookingForTheTitle(String title) {
        assertEquals(title, driver.getTitle());
    }

    @AfterStories
    public void tearDown() {
        driver.quit();
    }

}
