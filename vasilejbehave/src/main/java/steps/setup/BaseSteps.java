package steps.setup;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import uimappers.pages.EmagHomePage;
import uimappers.utils.WebDriverUtilities;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_ADDRESS;
import static uimappers.constants.TimeoutConstants.PAGE_LOADING_TIMEOUT;

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
    }

    @AfterStory
    public void teardown() {
        System.out.println("BANZAAAAIIIIIII ");
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
    public void openEmagPage(){
        sharedData.driver.get(PropertiesConfig.getProperty(HOME_ADDRESS));
        driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);
        sharedData.homePage = new EmagHomePage(sharedData);
    }
}
