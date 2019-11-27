package steps;

import driverprovider.DriverInstance;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import pages.EmagHomePage;
import pages.LoginPage;
import utils.Helper;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class CompareProductsSteps {

    public static WebDriver driver;
    public static EmagHomePage homePage;
    public LoginPage loginPage;
    private Helper helper = new Helper(driver);
    private Double firstPrice, secondPrice;

    @Given("I search for $product")
    public void searchForProduct(String product) throws InterruptedException {
        driver = DriverInstance.getDriver();
        homePage = new EmagHomePage(driver);
        driver.get("https://www.emag.ro/homepage?ref=emag_CMP-58472_top-products-by-reviews-noiembrie-2019");
        homePage.searchProduct(product);
    }

    @When("I get the prices for two items")
    public void comparePrices()  {
        firstPrice =  Double.parseDouble(homePage.getFirstPrice().substring(0,homePage.getFirstPrice().length()-4));
        secondPrice = Double.parseDouble(homePage.getSecondPrice().substring(0,homePage.getSecondPrice().length()-4));
        System.out.println(firstPrice+ " here  "+ secondPrice + "");
    }

    @Then("Price of first item should be greater")
    public void verifyPrices()  {
        System.out.println((firstPrice<secondPrice) + " rezzzz");
        assertTrue(firstPrice>secondPrice);
    }

    @AfterStory
    public void afterStory() {
        driver.quit();
    }
}
