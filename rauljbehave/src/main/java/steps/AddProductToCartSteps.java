package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import steps.setup.BaseSteps;
import utilities.SharedData;

import static junit.framework.TestCase.assertTrue;

public class AddProductToCartSteps extends BaseSteps {

    public AddProductToCartSteps(SharedData sharedData) {
        super(sharedData);
    }

    @Given("I log in")
    public void givenILogIn() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
        sharedData.loginPage.enterUserEmail();
        sharedData.loginPage.clickNext();
        sharedData.loginPage.enterUserPassword();
        sharedData.loginPage.clickNextValidPassword();
    }

    @Given("I search for $product")
    public void givenISearchForBrad(String product) {
        sharedData.searchPage = sharedData.homePage.searchProduct(product);
    }

    @When("I found first brad with discount badge")
    public void whenIFoundFirstBradWithDiscountBadge() {
        sharedData.searchPage.getProductWithDiscountBadge().click();
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

    @Then("my cart should not be empty")
    public void thenMyCartShouldNotBeEmpty() {
        int numberOfProductsFromCart = sharedData.cartPage.getItems().size();
        assertTrue(numberOfProductsFromCart != 0);
    }
}
