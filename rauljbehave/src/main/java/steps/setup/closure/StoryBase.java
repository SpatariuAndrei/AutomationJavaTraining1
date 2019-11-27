package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.FavoritesPage;
import steps.setup.BaseSteps;
import steps.setup.Browser;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class StoryBase extends BaseSteps {

    private DataFromPropertyFile propertyFile;

    public StoryBase(SharedData sharedData) {
        super(sharedData);
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
