package steps.setup.closure;

import org.jbehave.core.annotations.AfterStory;
import steps.setup.common.CleanUpCart;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class PlaceOrderBasicSteps extends AddProductToCartBrowserBasicSteps {

    private SharedData sharedData;
    private DataFromPropertyFile propertyFile;
    private CleanUpCart cleanUpCart;

    public PlaceOrderBasicSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData = sharedData;
        propertyFile = new DataFromPropertyFile();
    }

    @AfterStory
    public void afterScenario() {
        cleanUpCart.clean(sharedData,propertyFile);
    }
}
