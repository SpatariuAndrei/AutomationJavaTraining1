package bdd;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import pages.utils.PageFactoryUtils;
import properties.PropertiesConfig;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_ADDRESS;

public class BaseStory extends StoryMapper {
    protected SharedData share = new SharedData();

    public BaseStory(){
        share.driver = DriverInstance.getDriver();
        share.driver.get(PropertiesConfig.getProperty(HOME_ADDRESS));
    }

    @BeforeStory
    public void setup() {
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
}