package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.*;
import steps.setup.BaseSteps;
import utilities.SharedData;

import static junit.framework.TestCase.assertTrue;

public class AddProductToCartSteps extends BaseSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private CartPage cartPage;
    private ProductPage productPage;

    public AddProductToCartSteps(SharedData sharedData) {
        super(sharedData);
    }

    @Given("start page on emag")
    public void givenStartPageOnEmag() {
        homePage = new HomePage(sharedData.driver);
        loginPage = new LoginPage(sharedData.driver);
        searchPage = new SearchPage(sharedData.driver);
        cartPage = new CartPage(sharedData.driver);
        productPage = new ProductPage(sharedData.driver);
    }

    @Given("I log in")
    public void givenILogIn() {
        loginPage.get();
        loginPage.login();
    }

    @Given("I search for $product")
    public void givenISearchForBrad(String product) {
        homePage.searchProduct(product);
    }

    @When("I found first brad with discount badge")
    public void whenIFoundFirstBradWithDiscountBadge() {
        searchPage.getProductWithDiscountBadge().click();
    }

    @Then("I add it to my cart")
    public void thenIAddItToMyCart() {
        productPage.addToCart();
    }

    @When("I navigate to my cart")
    public void whenINavigateToMyCart() {
        productPage.viewCart();
    }

    @Then("my cart should not be empty")
    public void thenMyCartShouldNotBeEmpty() {
        int numberOfProductsFromCart = cartPage.getItems().size();
        assertTrue(numberOfProductsFromCart != 0);
    }
}
