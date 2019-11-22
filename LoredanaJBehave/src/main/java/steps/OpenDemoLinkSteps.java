package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class OpenDemoLinkSteps extends Steps {

    public static WebDriver driver;
    public static HomePage homePage;

    @Given("I open a browser")
    public void openingABrowser() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", filePath);
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        homePage.get();
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