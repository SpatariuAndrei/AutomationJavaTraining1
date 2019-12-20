package bdd.steps.functional.product;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import bdd.utilities.SharedData;

public class ProductSteps extends Steps {
    private SharedData sharedData;

    public ProductSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }


    @Given("I search for $product")
    public void givenISearchForProduct(@Named("product") String product) {
        sharedData.resultsPage=sharedData.homePage.searchProduct(product);
    }

    @When("I add the $product to my wishlist")
    public void thenIAddTheProductToMyWishlist(@Named("product") String product) {
        sharedData.resultsPage.addSearchResultsToFavorites(product);
    }

    @When("I navigate to wishlist")
    public void whenINavigateToWishlist() {
        sharedData.wishListPage = sharedData.resultsPage.navigateToFavorites();
    }
}
