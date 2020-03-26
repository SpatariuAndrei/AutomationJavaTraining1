package com.test.jbehave.steps;

import com.test.jbehave.pages.*;
import org.hamcrest.Matchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.time.Instant;

import static org.hamcrest.MatcherAssert.assertThat;

public class EmagSteps extends LifeCycleSteps {

    private String NEW_USER_EMAIL = "jbehave-testuser-"+ Instant.now().toEpochMilli()+"@endava.com";
    private String EXISTING_USER_EMAIL = "jbehave-testuser@endava.com";
    private String USER_PASSWORD = "nic3Earth94";
    private String USER_NAME = "Tester Endavan";

    private Home emagHomePage;
    private SearchResult emagSearchResultPage;
    private Cart emagCartPage;
    private Login emagLoginPage;
    private Register emagRegisterPage;

    @Given("I am on home page emag")
    public void givenIAmOnHomePageEmag() {
        emagHomePage = new Home();
        emagHomePage.go();
    }

    @When("I search for $product")
    public void whenISearchForProduct(String product) {
        emagSearchResultPage = emagHomePage.enterSearchQuery(product);
    }

    @Then("there are many products")
    public void thenThereAreManyProducts() {
        assertThat(emagSearchResultPage.getNumberOfProducts(), Matchers.greaterThan(0));
    }

    @Then("there are no products")
    public void thenThereAreNoProducts() {
        assertThat(emagSearchResultPage.getNumberOfProducts(), Matchers.equalTo(0));
    }

    @Given("that the cart is empty")
    public void givenThatTheCartIsEmpty() {
        emagCartPage = new Cart();
        emagCartPage.go();
        assertThat(emagCartPage.getNrOfItemsInCart(),Matchers.equalTo(0));
    }

    @When("the first item is added to the cart")
    public void whenTheFirstItemIsAddedToTheCart() {
        emagSearchResultPage.addFirstItemToCart();
    }

    @Then("the cart contains an item")
    public void thenTheCartContainsAnItem() {
        emagCartPage.go();
        assertThat(emagCartPage.getNrOfItemsInCart(),Matchers.equalTo(1));
    }

    @Given("the cart contains one item")
    public void givenTheCartContainsOneItem() {
        emagCartPage = new Cart();
        givenIAmOnHomePageEmag();
        whenISearchForProduct("scaun");
        whenTheFirstItemIsAddedToTheCart();
        thenTheCartContainsAnItem();
    }

    @When("the item is removed")
    public void whenTheItemIsRemoved() {
        emagCartPage.deleteFirstItemInCart();
    }

    @Then("the cart will be empty")
    public void thenTheCartWillBeEmpty() {
        assertThat(emagCartPage.getNrOfItemsInCart(),Matchers.equalTo(0));
    }

    @Given("I want to log in")
    public void givenIWantToLogIn() {
        emagLoginPage = emagHomePage.clickMyAccountButton();
    }

    @When("I enter new email")
    public void whenIEnterNewEmail() {
        emagLoginPage.enterEmail(NEW_USER_EMAIL);
        emagLoginPage.clickContinueButton();
    }

    @When("I enter existing email")
    public void whenIEnterExistingEmail() {
        emagLoginPage.enterEmail(EXISTING_USER_EMAIL);
        emagLoginPage.clickContinueButton();
    }

    @Then("I'm redirected to the register page to create a new account")
    public void thenImRedirectedToTheRegisterPageToCreateANewAccount() {
        emagRegisterPage = new Register();
        emagRegisterPage.enterName(USER_NAME);
        emagRegisterPage.enterPassword(USER_PASSWORD);
        emagRegisterPage.enterPasswordConfirmation(USER_PASSWORD);
        emagRegisterPage.checkAgreeTerms();
        emagRegisterPage.clickContinueButton();
    }

    @Then("I'm logged in")
    public void thenImLoggedIn() {
        assertThat(emagHomePage.isUserLoggedIn(), Matchers.equalTo(true));
    }

    @Then("I'm prompted to enter my password")
    public void thenImPromptedToEnterMyPassword() {
        emagLoginPage.enterPassword(USER_PASSWORD);
        emagLoginPage.clickContinueButton();
    }
}