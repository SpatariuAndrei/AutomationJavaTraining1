package com.test.jbehave.steps;

import com.test.jbehave.pages.PcGarageHomePage;
import com.test.jbehave.pages.PcGarageLoginSignUpPage;
import com.test.jbehave.utils.Base;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import java.io.IOException;

public class SignupSteps extends Base {

    PcGarageHomePage pcGarageHomePage;
    PcGarageLoginSignUpPage pcGarageLoginSignUpPage;

    @Given("I go to PCGarage <homePage>")
    public void givenIGoToPcgarageHomepage(@Named("homePage") String homePage) {
        pcGarageHomePage = new PcGarageHomePage();
        pcGarageHomePage.open(homePage);
    }

    @When("I go to My account")
    public void whenIGoToMyAccount() {
        pcGarageLoginSignUpPage = pcGarageHomePage.goToMyAccount();
    }

    @When("I sign up")
    public void whenISignUp() throws IOException, InvalidFormatException {
        pcGarageLoginSignUpPage.signUp();
    }

    @Then("I get an error message")
    public void thenIGetAnErrorMessage() {
        Assert.assertTrue(pcGarageLoginSignUpPage.isErrorTextDisplayed());
    }
}
