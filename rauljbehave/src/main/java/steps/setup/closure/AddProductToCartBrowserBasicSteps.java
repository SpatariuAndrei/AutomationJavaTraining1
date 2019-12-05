package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import pages.CartPage;
import pages.HomePage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class AddProductToCartBrowserBasicSteps extends StoryBase {

    private DataFromPropertyFile propertyFile;
    private SharedData sharedData;

    public AddProductToCartBrowserBasicSteps(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
        this.sharedData = sharedData;
        sharedData.cartPage = new CartPage(sharedData.driver);
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
        sharedData.cartPage.clean(sharedData, propertyFile);
    }
}
