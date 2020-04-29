package com.test.jbehave.steps;

import com.test.jbehave.pages.PcGarageCartPage;
import com.test.jbehave.pages.PcGarageHomePage;
import com.test.jbehave.pages.PcGarageProductPage;
import com.test.jbehave.pages.PcGarageSearchResultsPage;
import com.test.jbehave.utils.Base;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class ProductsCompareSteps extends Base {


    PcGarageHomePage pcGarageHomePage;
    PcGarageSearchResultsPage pcGarageSearchResultsPage;


    @Given("I go to PCGarage <homePage>")
    public void givenIGoToPcgarageHomepage(@Named("homePage") String homePage) {
        pcGarageHomePage = new PcGarageHomePage();
        pcGarageHomePage.open(homePage);
    }

    @When("I search for <productName>")
    public void whenISearchForProductname(@Named("productName") String productName) {
        pcGarageSearchResultsPage = pcGarageHomePage.searchForProduct(productName);
    }

    @Then("I verify if the products are displayed")
    public void thenIVerifyIfTheProductsAreDisplayed() {
        Assert.assertTrue(pcGarageSearchResultsPage.areProductsDisplayed());
    }
}
