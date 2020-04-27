package steps;

import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;
import org.testng.Assert;
import pageObjects.PcGarageHomePage;
import utils.SharedData;



public class ProductSearchSteps extends BaseSteps{

    SharedData sharedData;
    public ProductSearchSteps(SharedData sharedData){
        super(sharedData);
        this.sharedData=sharedData;
    }

    @Given("I go to PCGarage home page")
    public void givenIGoToPcgarageHomePage() {
        sharedData.pcGarageHomePage = new PcGarageHomePage(sharedData);
        sharedData.pcGarageHomePage.acceptCookies();
    }

    @When("I search for <productName>")
    public void whenISearchForProductname(@Named("productName") String productName) {
        sharedData.pcGarageSearchResultsPage = sharedData.pcGarageHomePage.searchForProduct(productName);
    }

    @Then("I verify if products are displayed")
    public void thenIVerifyIfProductsAreDisplayed() {
//    sharedData.pcGarageSearchResultsPage.addToComparationList();
    Assert.assertTrue(sharedData.pcGarageSearchResultsPage.areProductsDisplayed());
    }
}
