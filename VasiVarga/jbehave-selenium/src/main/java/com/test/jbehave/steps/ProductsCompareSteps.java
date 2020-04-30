package com.test.jbehave.steps;

import com.test.jbehave.pages.*;
import com.test.jbehave.utils.Base;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class ProductsCompareSteps extends Base {

    PcGarageHomePage pcGarageHomePage;
    PcGarageSearchResultsPage pcGarageSearchResultsPage;
    PcGarageComparationPage pcGarageComparationPage;

    @Given("I go to PCGarage <homePage>")
    public void givenIGoToPcgarageHomepage(@Named("homePage") String homePage) {
        pcGarageHomePage = new PcGarageHomePage();
        pcGarageHomePage.open(homePage);
        pcGarageHomePage.acceptTheCookies();
    }

    @When("I search for <productName>")
    public void whenISearchForProductname(@Named("productName") String productName) {
        pcGarageSearchResultsPage = pcGarageHomePage.searchForProduct(productName);
    }

    @When("I select the elements to compare")
    public void whenISelectTheElementsToCompare() {
        pcGarageSearchResultsPage.addToComparationList();
    }

    @When("I click on compare button")
    public void whenIClickOnCompareButton() {
        pcGarageComparationPage = pcGarageSearchResultsPage.clickCompareButton();
    }

    @Then("I verify if the products are displayed in the comparation list")
    public void thenIVerifyIfTheProductsAreDisplayedInTheComparationList() {
        Assert.assertTrue(pcGarageComparationPage.seeIfImOnTheRightPage());
    }

}
