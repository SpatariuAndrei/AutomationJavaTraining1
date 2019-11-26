package steps;

import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utils.SharedData;

import static org.testng.Assert.assertEquals;

public class SearchManyProductsSteps extends Steps {

    private SharedData sharedData;

    public SearchManyProductsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I search for $product")
    public void whenISearchForProduct(@Named("product") String product) throws InterruptedException {
        sharedData.homePage.searchProduct(product);
        sharedData.homePage.clearSearchBar();
    }

    @When("I add $product to favorites")
    public void whenIAddProductToFavorites(@Named("product") String product) throws InterruptedException {
        sharedData.homePage.addToFavorite();
    }

    @Then("I check $product appears in favorites")
    public void thenICheckProductAppearsInFavorites(@Named("product") String product) {
        assertEquals(sharedData.homePage.getNotificationText(),"Produsul a fost adaugat la Favorite","product can not be added to favorite products list");
    }
}
