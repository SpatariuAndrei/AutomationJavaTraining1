package com.test.jbehave.steps;

import com.test.jbehave.pages.Cart;
import com.test.jbehave.pages.Home;
import com.test.jbehave.pages.SearchResult;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;

public class EmagSteps extends LifeCycleSteps {

    private Home emagHomePage;
    private SearchResult emagSearchResultPage;
    private Cart emagCartPage;

    @Given("I am on home page emag")
    public void givenIAmOnHomePageEmag() {
        emagHomePage = new Home();
        emagHomePage.go();
    }

    @When("I search for $product")
    public void whenISearchForProduct(String product) {
        emagSearchResultPage = emagHomePage.enterSearchQuery(product);
    }

    @Then("there are many products")
    public void thenThereAreManyProducts() {
        assertThat(emagSearchResultPage.getNumberOfProducts(), Matchers.greaterThan(0));
    }

    @Then("there are no products")
    public void thenThereAreNoProducts() {
        assertThat(emagSearchResultPage.getNumberOfProducts(), Matchers.equalTo(0));
    }

    @Given("that the cart is empty")
    public void givenThatTheCartIsEmpty() {
        emagCartPage = new Cart();
        emagCartPage.go();
        assertThat(emagCartPage.getNrOfItemsInCart(),Matchers.equalTo(0));
    }

    @When("the first item is added to the cart")
    public void whenTheFirstItemIsAddedToTheCart() {
        emagSearchResultPage.addFirstItemToCart();
    }

    @Then("the cart contains an item")
    public void thenTheCartContainsAnItem() {
        emagCartPage.go();
        assertThat(emagCartPage.getNrOfItemsInCart(),Matchers.equalTo(1));
    }

    @Given("the cart contains one item")
    public void givenTheCartContainsOneItem() {
        emagCartPage = new Cart();
        givenIAmOnHomePageEmag();
        whenISearchForProduct("scaun");
        whenTheFirstItemIsAddedToTheCart();
        thenTheCartContainsAnItem();
    }

    @When("the item is removed")
    public void whenTheItemIsRemoved() {
        emagCartPage.deleteFirstItemInCart();
    }

    @Then("the cart will be empty")
    public void thenTheCartWillBeEmpty() {
        assertThat(emagCartPage.getNrOfItemsInCart(),Matchers.equalTo(0));
    }
}