package steps;

import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Test;
import org.testng.Assert;
import pageobjects.PcGarageHomePage;
import utils.SharedData;

public class AddToCartSteps extends BaseSteps {


    SharedData sharedData;

    public AddToCartSteps(SharedData sharedData) {
        super(sharedData);
    }


    @Test

    @Step
    public void givenIGoToPcgarageHomePage() {
        sharedData.pcGarageHomePage = new PcGarageHomePage(sharedData);
    }

    @Step
    @When("I search for <product>")
    public void whenISearchForProduct(@Named("product") String product){
        sharedData.pcGarageSearchResultsPage = sharedData.pcGarageHomePage.searchForProduct(product);
    }

    @Step
    @When("I go to the <productName> page")
    public void whenIGoToTheProductPage(@Named("productName") String productName){
        sharedData.pcGarageProductPage = sharedData.pcGarageSearchResultsPage.selectProductByName(productName);
    }

    @Step
    @When("I add it to my cart")
    public void whenIAddItToMyCart() {
        sharedData.pcGarageCartPage = sharedData.pcGarageProductPage.addToChart();
    }

    @Step
    @Then("I can see the <cartProductName> in my cart")
    public void thenICanSeeTheProductnameInMyCart(@Named("cartProductName") String cartProductName) {
        Assert.assertTrue(sharedData.pcGarageCartPage.isProductInCart(cartProductName));
    }


}
