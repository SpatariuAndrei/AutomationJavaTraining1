package com.test.jbehave.steps;

import com.test.jbehave.pages.PcGarageCartPage;
import com.test.jbehave.pages.PcGarageHomePage;
import com.test.jbehave.pages.PcGarageProductPage;
import com.test.jbehave.pages.PcGarageSearchResultsPage;
import com.test.jbehave.utils.Base;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;


public class AddToCartSteps extends Base {

    PcGarageHomePage pcGarageHomePage;
    PcGarageSearchResultsPage pcGarageSearchResultsPage;
    PcGarageProductPage pcGarageProductPage;
    PcGarageCartPage pcGarageCartPage;

    @Given("I go to PCGarage <homePage>")
    public void givenIGoToPcgarageHomepage(@Named("homePage") String homePage) {
        pcGarageHomePage = new PcGarageHomePage();
        pcGarageHomePage.open(homePage);
        pcGarageHomePage.acceptTheCookies();
    }

    @When("I search for <product>")
    public void whenISearchForProduct(@Named("product") String product){
        pcGarageSearchResultsPage = pcGarageHomePage.searchForProduct(product);
    }

    @When("I go to the <productName> page")
    public void whenIGoToTheProductPage(@Named("productName") String productName){
        pcGarageProductPage = pcGarageSearchResultsPage.selectProductByName(productName);
    }

    @When("I add it to my cart")
    public void whenIAddItToMyCart() {
        pcGarageCartPage = pcGarageProductPage.addToChart();
    }

    @Then("I can see the <cartProductName> in my cart")
    public void thenICanSeeTheProductnameInMyCart(@Named("cartProductName") String cartProductName)
    {
        Assert.assertTrue(pcGarageCartPage.isProductInCart(cartProductName));
    }

}