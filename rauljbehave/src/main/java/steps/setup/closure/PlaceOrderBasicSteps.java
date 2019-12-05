package steps.setup.closure;

import org.jbehave.core.annotations.AfterStory;
import pages.CartPage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class PlaceOrderBasicSteps extends AddProductToCartBrowserBasicSteps {

    private SharedData sharedData;
    private DataFromPropertyFile propertyFile;

    public PlaceOrderBasicSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData = sharedData;
        propertyFile = new DataFromPropertyFile();
        sharedData.cartPage = new CartPage(sharedData.driver);
    }

    @AfterStory
    public void afterScenario() {
        sharedData.cartPage.clean(sharedData,propertyFile);
    }
}
