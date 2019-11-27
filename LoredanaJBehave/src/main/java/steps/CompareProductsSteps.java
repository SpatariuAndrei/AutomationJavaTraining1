package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utils.Helper;
import utils.SharedData;

import static org.testng.Assert.assertTrue;

public class CompareProductsSteps extends Steps {

    private Helper helper;
    private Double firstPrice, secondPrice;
    private SharedData sharedData;

    public CompareProductsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
        helper = new Helper(sharedData);
    }

    @Given("I search for $product")
    public void searchForProduct(String product) {
        sharedData.productResultsPage = sharedData.homePage.searchProduct(product);
    }

    @When("I get the prices for two items")
    public void comparePrices() {
        firstPrice = Double.parseDouble(sharedData.productResultsPage.getFirstPrice().substring(0, sharedData.productResultsPage.getFirstPrice().length() - 4));
        secondPrice = Double.parseDouble(sharedData.productResultsPage.getSecondPrice().substring(0, sharedData.productResultsPage.getSecondPrice().length() - 4));
    }

    @Then("Price of first item should be greater")
    public void verifyPrices() {
        assertTrue(firstPrice < secondPrice);
    }
}
