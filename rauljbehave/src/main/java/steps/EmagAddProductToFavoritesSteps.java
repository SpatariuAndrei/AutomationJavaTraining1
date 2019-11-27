package steps;

import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;
import pages.LoginPage;
import utilities.SharedData;

import static junit.framework.TestCase.assertTrue;

public class EmagAddProductToFavoritesSteps extends Steps {

    private SharedData sharedData;

    public EmagAddProductToFavoritesSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @BeforeStory
    public void beforeSearchingAndAddingProductsToFavorites() {
        sharedData.loginPage = new LoginPage(sharedData.driver);
        sharedData.loginPage.get();
        sharedData.userHomePage = sharedData.loginPage.login();
    }

    @Given("I open eMag user home page")
    public void givenIOpenEmagUserHomePage() {
        sharedData.userHomePage.get();
    }

    @When("I search the <product>")
    public void whenISearchTheProduct(@Named("product") String product) {
        sharedData.searchPage = sharedData.userHomePage.searchProduct(product);
    }

    @When("I add it to favorites")
    public void thenIAddItToFavorites() {
        sharedData.searchPage.addToFavorite();
    }


    @When("I navigate to favorites product page")
    public void whenINavigateToFavoritesProductPage() {
        sharedData.favoritesPage = sharedData.searchPage.goToProductFavoritesPage();
    }


    @Then("I check that <product> is present")
    public void thenICheckThatProductIsPresent(@Named("product") String product) {
        assertTrue(sharedData.favoritesPage.getElements(product));
    }
}
