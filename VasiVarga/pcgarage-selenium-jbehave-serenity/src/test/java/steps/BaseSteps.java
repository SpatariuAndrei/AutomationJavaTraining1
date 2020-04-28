package steps;

import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.core.steps.Steps;
import utils.SharedData;

public abstract class BaseSteps extends Steps {

    private SharedData sharedData;

    public BaseSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @BeforeStory
    public void setup() {
        System.out.println("BEFORE STORY");
        sharedData.driver.manage().window().maximize();
    }
}
