package com.test.jbehave.steps;

import com.test.jbehave.pages.PcGarageHomePage;
import com.test.jbehave.pages.PcGarageLoginSignUpPage;
import com.test.jbehave.utils.Base;
import com.test.jbehave.utils.Driver;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import java.io.IOException;

public class AccountSteps extends Base {

    PcGarageHomePage pcGarageHomePage;
    PcGarageLoginSignUpPage pcGarageLoginSignUpPage;

    @Given("I go to PCGarage <homePage>")
    public void givenIGoToPcgarageHomepage(@Named("homePage") String homePage) {
        pcGarageHomePage = new PcGarageHomePage();
        pcGarageHomePage.open(homePage);
        pcGarageHomePage.acceptTheCookies();
    }

    @Given("I go to PCGarage home page")
    public void givenIGoToPcgarageHomePage() {
        pcGarageHomePage = new PcGarageHomePage();
        pcGarageHomePage.open("https://pcgarage.ro");
        pcGarageHomePage.acceptTheCookies();
    }

    @When("I go to My account")
    public void whenIGoToMyAccount() {
        pcGarageLoginSignUpPage = pcGarageHomePage.goToMyAccount();
    }

    @When("I sign up")
    public void whenISignUp() throws IOException, InvalidFormatException {
        pcGarageLoginSignUpPage.signUp();
    }

    @When("I enter my username and password")
    public void whenIEnterMyUsernameAndPassword() throws IOException, InvalidFormatException {
        pcGarageLoginSignUpPage.signInWithValidCredentials();
    }

    @When("I enter my wrong username and password")
    public void whenIEnterMyWrongUsernameAndPassword() {
        pcGarageLoginSignUpPage.signInWithInvalidCredentials();
    }

    @Then("I see my account")
    public void thenISeeMyAccount() {
        Assert.assertEquals(Driver.driver.getCurrentUrl(),"https://www.pcgarage.ro/cont/");
    }


    @Then("I get an error message")
    public void thenIGetAnErrorMessage() {
        Assert.assertTrue(pcGarageLoginSignUpPage.isErrorTextDisplayed());
    }


}
