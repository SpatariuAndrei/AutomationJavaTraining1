package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utils.Helper;
import utils.SharedData;

import static org.testng.Assert.assertTrue;

public class CompareProductsSteps extends Steps {

    private Helper helper ;
    private Double firstPrice, secondPrice;
    private SharedData sharedData;

    public CompareProductsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
        helper = new Helper(sharedData);
    }

    @When("I search for $product")
    public void searchForProduct(String product) throws InterruptedException {
        sharedData.homePage.searchProduct(product);
    }

    @When("I get the prices for two items")
    public void comparePrices()  {
        firstPrice =  Double.parseDouble(sharedData.homePage.getFirstPrice().substring(0,sharedData.homePage.getFirstPrice().length()-4));
        secondPrice = Double.parseDouble(sharedData.homePage.getSecondPrice().substring(0,sharedData.homePage.getSecondPrice().length()-4));
    }

    @Then("Price of first item should be greater")
    public void verifyPrices()  {
        assertTrue(firstPrice>secondPrice);
    }
}
