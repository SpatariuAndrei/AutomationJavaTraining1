package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.UserHomePage;
import utilities.SharedData;

public class LoginBrowserBasicSteps extends StoryBase {

    private SharedData sharedData;

    public LoginBrowserBasicSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData = sharedData;
    }

    @Given("I open eMag home page")
    public void givenIOpenEmagHomePage() {
        sharedData.homePage = new HomePage(sharedData.driver);
        sharedData.homePage.get();
    }

    @AfterScenario
    public void afterScenario() {
        UserHomePage userHomePage = PageFactory.initElements(sharedData.driver, UserHomePage.class);
        userHomePage.logOut();
    }
}
