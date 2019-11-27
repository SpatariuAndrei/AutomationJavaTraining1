package utils;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import steps.BaseSteps;


public class StoryBase extends BaseSteps {

    private DataFromPropertyFile propertyFile;

    public StoryBase(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
    }

    @BeforeStory
    public void setup() {
        sharedData.driver = DriverInstance.getDriver();
    }

    @AfterStory
    public void teardown() {
        sharedData.driver.quit();
    }

    @AfterScenario
    public void afterScenario() {

    }
}