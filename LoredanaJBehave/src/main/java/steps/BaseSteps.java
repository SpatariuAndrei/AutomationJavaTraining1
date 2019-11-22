package steps;

import org.jbehave.core.steps.Steps;
import utils.SharedData;

public class BaseSteps extends Steps {

    protected SharedData sharedData;

    public BaseSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }
}
