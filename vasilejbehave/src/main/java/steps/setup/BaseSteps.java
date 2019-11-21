package steps.setup;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import uimappers.pages.EmagHomePage;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_ADDRESS;

public class BaseSteps extends Steps {
    private SharedData share;

    public BaseSteps(SharedData share) {
        this.share = share;
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
        share.driver.get(PropertiesConfig.getProperty(HOME_ADDRESS));
        share.homePage=new EmagHomePage(share);
    }
}
