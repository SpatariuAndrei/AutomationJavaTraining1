package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utils.SharedData;

import static org.testng.Assert.assertTrue;

public class BuySomeProductsSteps extends Steps {

    private SharedData sharedData;

    public BuySomeProductsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I search for $product")
    public void givenISearchForGuess(String product) {
        sharedData.productResultsPage = sharedData.homePage.searchProduct(product);
    }

    @When("I add a product to cart")
    public void whenIAddAProductToCart() {
        sharedData.productResultsPage.addToCart();
    }

    @When("I click on product details")
    public void whenIClickOnProductDetails() {
        sharedData.cartPage = sharedData.productResultsPage.clickOnCartDetails();
    }

    @When("I press on Continua")
    public void whenIPressOnContinua() {
        sharedData.orderDetailsPage = sharedData.cartPage.clickOnContinueButton();
    }

    @When("I select Livrare prin curier")
    public void whenISelectLivrarePrinCurier() {
        sharedData.orderDetailsPage.selectLivrarePrinCurier();
    }

    @When("I select Ramburs la curier")
    public void whenISelectRambursLaCurier() {
        sharedData.orderDetailsPage.selectRambursLaCurier();
    }

    @When("I click on Pasul urmator")
    public void whenIClickOnPasulUrmator() {
        sharedData.orderSummaryPage = sharedData.orderDetailsPage.clickOnPasulUrmator();
    }

    @Then("I should see Trimie comanda button")
    public void thenIShouldSeeTrimieComandaButton() {
        assertTrue(sharedData.orderSummaryPage.verifyMessage());
    }
}
