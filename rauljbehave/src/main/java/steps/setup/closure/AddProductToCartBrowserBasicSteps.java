package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import pages.HomePage;
import steps.setup.common.CleanUpCart;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class AddProductToCartBrowserBasicSteps extends StoryBase {

    private DataFromPropertyFile propertyFile;
    private SharedData sharedData;
    private CleanUpCart cleanUpCart;

    public AddProductToCartBrowserBasicSteps(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
        this.sharedData = sharedData;
    }

    @Given("I open eMag home page")
    public void givenIOpenEmagHomePage() {
        sharedData.homePage = new HomePage(sharedData.driver);
        sharedData.homePage.get();
    }

    @Given("I log in")
    public void givenILogIn() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
        sharedData.loginPage.enterUserEmail();
        sharedData.loginPage.clickNext();
        sharedData.loginPage.enterUserPassword();
        sharedData.loginPage.clickNextValidPassword();
    }

    @AfterScenario
    public void afterScenario() {
        cleanUpCart.clean(sharedData, propertyFile);
    }
}
