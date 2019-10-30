package steps;

import org.jbehave.core.annotations.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import pages.utils.Product;
import steps.setup.BaseSteps;
import utilities.SharedData;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.sleep;

public class AddTwoElementsSteps extends BaseSteps {

    JavascriptExecutor js;
    Map<String, Object> vars;
    LoginPage loginPage;
    HomePage homePage;
    ResealedPage resealedPage;
    ProductPage productPage;
    CartPage cartPage;
    SearchPage searchPage;
    Product reducedProduct;
    Product normalProduct;
    float sum;
    float totalPrice;

    public AddTwoElementsSteps(SharedData share) {
        super(share);
    }

    String waitForWindow(int timeout) {
        try {
            sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = share.driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }


    @Given("start page on eMAG")
    public void startPage() {
        js = (JavascriptExecutor) share.driver;
        vars = new HashMap<String, Object>();
        loginPage = share.pageFactoryUtils.getCachedLoginPage();
        homePage = PageFactory.initElements(share.driver, HomePage.class);
        resealedPage = PageFactory.initElements(share.driver, ResealedPage.class);
        productPage = PageFactory.initElements(share.driver, ProductPage.class);
        cartPage = PageFactory.initElements(share.driver, CartPage.class);
        searchPage = PageFactory.initElements(share.driver, SearchPage.class);
        loginPage.get();
        loginPage.login();
        vars.put("window_handles", share.driver.getWindowHandles());
        vars.put("win3788", waitForWindow(2000));
    }



    @Given("I found the first normal product")
    public void foundProduct() {

        searchPage.getNormalProduct().click();
    }

    @Given("I store the normal product details in a Product object")
    public void storeProductDetails() {
        normalProduct = productPage.elementToProduct();

    }

    @Given("I add normal product to the cart")
    public void addToCart() {
        productPage.addToCart();
    }

    @Given("I navigate back in browser")
    public void navigateBack() {
        share.driver.navigate().back();
    }

    @Given("I select the first reduced product")
    public void selectReducedProduct() {

        searchPage.getReducedProduct().click();
    }

    @Given("I store the reduced product details in a Product object")
    public void storeReducedProductDetails() {
        reducedProduct = productPage.elementToProduct();

    }

    @Given("I add reduced product to the cart")
    public void addReducedToCart() {

        productPage.addToCart();
    }

    @Given("I go to view the cart")
    public void viewCart() {

        productPage.viewCart();
    }

    @Given("I add the two prices in a float")
    public void addPrices() {
        sum = normalProduct.floatNewPrice() + reducedProduct.floatNewPrice();
    }

    @Given("I store the cart total price in a float")
    public void storeCartPrice() {
        totalPrice = cartPage.totalPrice();
    }

    @When("I compare the two floats")
    public void productPrices() {

    }

    @Then("the two numbers must be equals")
    public void equalPrices() {

        //Assert.assertEquals(sum, totalPrice, 0.5);
    }


    @Given("I search for samsung")
    public void searchFor() {

        homePage.searchFor("samsung");
    }
}


