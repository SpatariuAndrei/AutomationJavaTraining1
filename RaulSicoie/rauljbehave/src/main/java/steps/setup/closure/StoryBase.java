package steps.setup.closure;


import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.steps.Steps;
import steps.setup.Browser;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class StoryBase extends Steps {

    private DataFromPropertyFile propertyFile;
    private SharedData sharedData;

    public StoryBase(SharedData sharedData) {
        this.sharedData = sharedData;
        propertyFile = new DataFromPropertyFile();
    }

    @BeforeStory
    public void setup() {
        sharedData.driver = new Browser().driverInitialization();
    }

    @AfterStory
    public void teardown() {
        sharedData.driver.quit();
    }

}
