package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import pages.FavoritesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class EmagAddProductToFavoritesSteps extends BaseSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private SearchPage searchPage;
    private FavoritesPage favoritesPage;

    public EmagAddProductToFavoritesSteps(SharedData sharedData) {
        super(sharedData);
    }

    @Given("start page on emag")
    public void givenStartPageOnEmag() {
        homePage = new HomePage(sharedData.driver);
        loginPage = new LoginPage(sharedData.driver);
        searchPage = new SearchPage(sharedData.driver);
        favoritesPage = new FavoritesPage(sharedData.driver);
    }

    @Given("I log in")
    public void givenILogIn() {
        loginPage.get();
        loginPage.login();
    }

    @When("I found $device")
    public void whenIFoundDevice(String device) {
        homePage.searchProduct(device);
    }

    @Then("I add it to favorites")
    public void thenIAddItToFavorites() {
        searchPage.addToFavorite();
    }

}
