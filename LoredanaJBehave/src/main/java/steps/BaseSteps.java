package steps;


import driverprovider.DriverInstance;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import pages.EmagHomePage;
import utils.DataFromPropertyFile;
import utils.SharedData;
import utils.WebDriverUtilities;

public class BaseSteps extends Steps {
    private SharedData sharedData;
    private WebDriverUtilities driverUtilities;

    public BaseSteps(SharedData sharedData) {
        driverUtilities = new WebDriverUtilities();
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
    public void teardown() {
        DriverInstance.quitDriver();
    }

    @BeforeScenario
    public void beforeScenario() {
        //replace with logging
        System.out.println("THIS IS MY BEFORE SCENARIO ");

    }

    @AfterScenario
    public void afterScenario(){
        System.out.println("THIS IS MY AFTER SCENARIO ");
    }

    /**
     * Base steps
     */
    @Given("I open eMAG home page")
    public void openEmagPage() {
//        sharedData.driver.get(DataFromPropertyFile.getBaseURL());
//        driverUtilities.waitUntilPageIsLoaded(60);
//        sharedData.homePage = new EmagHomePage(sharedData);
    }
}
