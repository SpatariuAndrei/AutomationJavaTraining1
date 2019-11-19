package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertEquals;

public class DisplayUrlSteps extends Steps {

    private static WebDriver driver = null;

    @Given("I open a browser")
    public void openingBrowser() {
        String chromePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @When("I enter $url and hit enter key")
    public void enteringUrl(String url) {
        driver.get(url);
    }

    @Then("$title is displayed")
    public void lookingForTheTitle(String title) {
        assertEquals(title, driver.getTitle());
    }

}
