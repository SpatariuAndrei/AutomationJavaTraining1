package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import pages.EmagHomePage;
import pages.LoginPage;
import utils.Helper;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class AddToFavoriteProductsSteps {

    public static WebDriver driver;
    public static EmagHomePage homePage;
    public LoginPage loginPage;
    private Helper helper = new Helper(driver);

    @Given("I'm logged in as $name")
    public void openingABrowser(String name)  {
        driver = helper.instantiateChromeDriver();
        homePage = new EmagHomePage(driver);
        driver.get("https://www.emag.ro/");
        //homePage.moveOverProfilePicture();
       // assertEquals( homePage.getMessage(name),"Salut, Coroama Loredana", "Not logged in");
    }

    @When("I search for $name")
    public void searchProduct(String name) throws InterruptedException {
        homePage.searchProduct(name);
    }

//    @When("I click on first product")
//    public void clickFirstProduct() {
//       homePage.clickOnFirstProduct();
//    }
//
//    @Then("I should e redirected to details page")
//    public void goToDetailsPage()  {
//        System.out.print("it works");
//    }

    @When("I add the product to favorite")
    public void addProductToFavorite()  {
        homePage.addToFavorite();
    }

    @Then("I should see product in favorite products")
    public void seeProducts()  {
        assertEquals(homePage.getNotificationText(),"","product can not be added to favorite products list");

    }


}
