package steps;

import org.jbehave.core.annotations.Given;
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

    @Given("I search for $product")
    public void whenISearchForProduct(@Named("product") String product) {
        sharedData.productResultsPage = sharedData.homePage.searchProduct(product);
    }

    @When("I add the product to favorites")
    public void whenIAddProductToFavorites() {
        sharedData.productResultsPage.addToFavorite();
    }

    @Then("I verify the message")
    public void thenICheckProductAppearsInFavorites() {
        assertEquals(sharedData.homePage.getNotificationText(), "Produsul a fost adaugat la Favorite", "product can not be added to favorite products list");
    }
}
