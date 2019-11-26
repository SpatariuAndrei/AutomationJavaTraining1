package steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utils.Helper;
import utils.SharedData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToFavoriteProductsSteps extends Steps {

    private Helper helper;

    private SharedData sharedData;

    public AddToFavoriteProductsSteps(SharedData sharedData) {
        this.sharedData = sharedData;
        helper = new Helper(sharedData);
    }

    @When("I search for $name")
    public void searchProduct(String name) throws InterruptedException {
       sharedData.homePage.searchProduct(name);
    }

    @When("I add the product to favorite")
    public void addProductToFavorite() throws InterruptedException {
        sharedData.homePage.addToFavorite();
    }

    @Then("I should see product in favorite products")
    public void seeProducts()  {
        assertEquals(sharedData.homePage.getNotificationText(),"Produsul a fost adaugat la Favorite","product can not be added to favorite products list");
    }

    @When("I add a product to cart")
    public void addProductToCart() throws InterruptedException {
        sharedData.homePage.addToFavorite(); // deleted from favorites
        sharedData.homePage.addToCart();
    }

    @When("I click on cart details")
    public void viewCartDetails() throws InterruptedException {
        sharedData.cartPage = sharedData.homePage.clickOnCartDetails();
    }

    @When("I delete the product from cart")
    public void deleteProductFromCart(){
        sharedData.cartPage.deleteProductFromCart();
    }

    @Then("I should receive a message")
    public void verifyMessage(String message) throws InterruptedException {
        sharedData.homePage.addToFavorite();
        assertTrue(sharedData.cartPage.isMessageDisplayed());
    }
}
