package steps;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.EmagHomePage;
import pages.LoginPage;
import utils.Helper;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToFavoriteProductsSteps {

    public static WebDriver driver;
    public static EmagHomePage homePage;
    public LoginPage loginPage;
    public CartPage cartPage;
    private Helper helper = new Helper(driver);

    @Given("I'm logged in as $name")
    public void openingABrowser(String name)  {
        driver = DriverInstance.getDriver();
        homePage = new EmagHomePage(driver);
        driver.get("https://www.emag.ro/");
    }

    @When("I search for $name")
    public void searchProduct(String name) throws InterruptedException {
        homePage.searchProduct(name);
    }

    @When("I add the product to favorite")
    public void addProductToFavorite() throws InterruptedException {
        homePage.addToFavorite();
    }

    @Then("I should see product in favorite products")
    public void seeProducts()  {
        assertEquals(homePage.getNotificationText(),"Produsul a fost adaugat la Favorite","product can not be added to favorite products list");
    }

    @When("I add a product to cart")
    public void addProductToCart() {
        homePage.addToCart();
    }

    @When("I click on cart details")
    public void viewCartDetails() throws InterruptedException {
        cartPage = homePage.clickOnCartDetails();
    }

    @When("I delete the product from cart")
    public void deleteProductFromCart(){
        cartPage.deleteProductFromCart();
    }

    @Then("I should receive a message")
    public void verifyMessage(String message) {
        assertTrue(cartPage.isMessageDisplayed());
    }
}
