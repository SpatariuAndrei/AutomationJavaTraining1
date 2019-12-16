package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utilities.SharedData;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class AddProductToCartSteps extends Steps {

    private SharedData sharedData;

    public AddProductToCartSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I search for $product")
    public void givenISearchForBrad(String product) {
        sharedData.searchPage = sharedData.homePage.searchProduct(product);
    }

    @When("I found first brad with discount badge")
    public void whenIFoundFirstBradWithDiscountBadge() {
        sharedData.productPage = sharedData.searchPage.foundProductWithDiscountBadge();
    }

    @When("I add it to my cart")
    public void thenIAddItToMyCart() {
        sharedData.productPage.addToCart();
    }

    @When("I navigate to my cart")
    public void whenINavigateToMyCart() {
        sharedData.cartPage = sharedData.productPage.viewCart();
    }

    @Then("check $product was added to cart")
    public void thenMyCartShouldNotBeEmpty(String product) {
        List<String> elements = sharedData.cartPage.getElementsFromCart();
        for (String elem : elements) {
            String actualValue = elem.toString();
            assertTrue(actualValue.contains(product));
        }
    }
}
