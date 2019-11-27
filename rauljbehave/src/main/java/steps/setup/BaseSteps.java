package steps.setup;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.steps.Steps;
import pages.HomePage;
import utilities.SharedData;

public class BaseSteps extends Steps {

    protected SharedData sharedData;

    public BaseSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }
}
