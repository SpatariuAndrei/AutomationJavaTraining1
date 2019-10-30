package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
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

public class EmagNormalProductSteps extends BaseSteps {


    private Product originalProduct;
    private Product cartProduct;
    JavascriptExecutor js;
    Map<String, Object> vars;
    LoginPage loginPage;
    HomePage homePage;
    ResealedPage resealedPage;
    ProductPage productPage;
    CartPage cartPage;
    SearchPage searchPage;

    public EmagNormalProductSteps(SharedData share) {
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
    public void startPage(){
        js = (JavascriptExecutor) share.driver;
        vars = new HashMap<String, Object>();
        loginPage = PageFactory.initElements(share.driver, LoginPage.class);
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

    @Given("I search for iphone")
    public void searchFor(){

        homePage.searchFor("samsung");
    }

    @Given("I found the first normal product")
    public void foundProduct(){

        searchPage.getNormalProduct().click();
    }

    @Given("I store the details in a Product object")
    public  void storeProductDetails(){
        originalProduct = productPage.elementToProduct();

    }

    @Given("I add it to the cart")
    public void addToCart(){
        productPage.addToCart();
    }

    @Given("I go to view the cart")
    public void viewCart(){

        productPage.viewCart();
    }

    @Given("I store the product from the cart in another Product object")
    public void storeCartProduct(){
        cartProduct = cartPage.getProduct(1);

    }

    @When("I compare the prices of Product objects")
    public void productPrices(){

    }
    @Then("the two prices must be equals")
    public void equalPrices(){

       // Assert.assertEquals(originalProduct.getNewPrice(), cartProduct.getNewPrice());
    }



}

