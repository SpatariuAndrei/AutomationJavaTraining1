package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.UserHomePage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class LoginEndingStory extends StoryBase{

    private DataFromPropertyFile propertyFile;

    public LoginEndingStory(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
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
