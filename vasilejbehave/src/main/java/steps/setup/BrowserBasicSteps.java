package steps.setup;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import uimappers.constants.UserMenuOptions;
import uimappers.pages.EmagHomePage;
import uimappers.utils.WebDriverUtilities;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_URL;
import static uimappers.constants.TimeoutConstants.PAGE_LOADING_TIMEOUT;

public class BrowserBasicSteps extends Steps {
    private SharedData sharedData;
    private WebDriverUtilities driverUtilities;

    public BrowserBasicSteps(SharedData sharedData) {
        driverUtilities = new WebDriverUtilities();
        this.sharedData = sharedData;
    }

    /**
     * Hooks
     */
    @BeforeStory
    public void setup() {
        //replace with logging
        System.out.println("THIS IS MY BEFORE STORY ");
        driverUtilities = new WebDriverUtilities();
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
    public void afterScenario() {
        System.out.println("LOGOUT AFTER SCENARIO");
        sharedData.homePage.logout(UserMenuOptions.LOG_OUT);
    }


    /**
     * Base steps
     */
    @Given("I open eMAG home page")
    public void openEmagPage(){
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_URL));
        driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);
        sharedData.homePage = new EmagHomePage(sharedData);
    }
}
