package steps;


import driverprovider.DriverInstance;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.steps.Steps;
import pages.EmagHomePage;
import pages.FavoritesPage;
import utils.DataFromPropertyFile;
import utils.SharedData;
import utils.WebDriverUtilities;

public class BaseSteps extends Steps {
    private SharedData sharedData;
    private WebDriverUtilities driverUtilities;

    public BaseSteps(SharedData sharedData) {
        driverUtilities = new WebDriverUtilities(sharedData);
        this.sharedData = sharedData;
    }

    /**
     * Hooks
     */
    @BeforeStory
    public void setup() {
        //replace with logging
        System.out.println("THIS IS MY BEFORE STORIES ");
        sharedData.driver.get(DataFromPropertyFile.getBaseURL());
        driverUtilities.waitUntilPageIsLoaded(60);
        sharedData.driver.manage().window().maximize();
        sharedData.homePage = new EmagHomePage(sharedData);
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
        String emailAddress = DataFromPropertyFile.getEmail();
        sharedData.loginPage.enterEmail(emailAddress);
        sharedData.loginPage.clickOnContinue();
        String passwordValue = DataFromPropertyFile.getPassword();
        sharedData.loginPage.enterPassword(passwordValue);
        sharedData.homePage = sharedData.loginPage.clickOnContinue2();
    }

    @AfterStory
    public void teardown() throws InterruptedException {
        sharedData.driver.navigate().to(DataFromPropertyFile.getFavoritesPage());
        sharedData.favoritesPage = new FavoritesPage(sharedData);
        sharedData.favoritesPage.deleteAllFavoriteProducts();
        DriverInstance.quitDriver();
    }

    @BeforeScenario
    public void beforeScenario() {
        //replace with logging
        System.out.println("THIS IS MY BEFORE SCENARIO ");

    }

    @AfterScenario
    public void afterScenario() {
        System.out.println("THIS IS MY AFTER SCENARIO ");
    }

}
