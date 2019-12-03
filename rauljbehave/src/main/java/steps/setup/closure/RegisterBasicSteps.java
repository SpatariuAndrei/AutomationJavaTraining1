package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class RegisterBasicSteps extends AddProductToCartBrowserBasicSteps {

    private SharedData sharedData;
    private DataFromPropertyFile propertyFile;

    public RegisterBasicSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData = sharedData;
        propertyFile = new DataFromPropertyFile();
    }

    @AfterScenario
    public void afterScenario() {

    }
}
