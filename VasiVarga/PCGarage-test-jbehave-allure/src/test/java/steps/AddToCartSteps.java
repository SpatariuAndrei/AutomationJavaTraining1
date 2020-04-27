package steps;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.testng.Assert;
import pageObjects.PcGarageHomePage;
import ru.yandex.qatools.allure.annotations.Step;
import utils.SharedData;


public class AddToCartSteps extends BaseSteps {

    @Steps

    SharedData sharedData;

    public AddToCartSteps(SharedData sharedData) {
        super(sharedData);
        this.sharedData=sharedData;
    }


    @Given("I go to PCGarage home page")
    public void givenIGoToPcgarageHomePage() {
        sharedData.pcGarageHomePage = new PcGarageHomePage(sharedData);
        sharedData.pcGarageHomePage.acceptCookies();
    }

    @When("I search for <product>")
    public void whenISearchForProduct(@Named("product") String product){
        sharedData.pcGarageSearchResultsPage = sharedData.pcGarageHomePage.searchForProduct(product);
    }

    @When("I go to the <productName> page")
    public void whenIGoToTheProductPage(@Named("productName") String productName){
        sharedData.pcGarageProductPage = sharedData.pcGarageSearchResultsPage.selectProductByName(productName);
    }

    @When("I add it to my cart")
    public void whenIAddItToMyCart() {
        sharedData.pcGarageCartPage = sharedData.pcGarageProductPage.addToChart();
    }

    @Then("I can see the <cartProductName> in my cart")
    public void thenICanSeeTheProductnameInMyCart(@Named("cartProductName") String cartProductName) {
        Assert.assertTrue(sharedData.pcGarageCartPage.isProductInCart(cartProductName));
    }


}
