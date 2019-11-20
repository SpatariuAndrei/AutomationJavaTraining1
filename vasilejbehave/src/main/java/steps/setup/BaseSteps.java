package steps.setup;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.steps.Steps;
import properties.PropertiesConfig;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_ADDRESS;

public class BaseSteps extends Steps {
    private SharedData share;

    public BaseSteps(SharedData share) {
        this.share = share;
    }

    @Given("I open eMAG home page")
    public void openEmagPage(){
        share.driver.get(PropertiesConfig.getProperty(HOME_ADDRESS));
    }
}
