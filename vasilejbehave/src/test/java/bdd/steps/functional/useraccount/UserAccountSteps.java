package bdd.steps.functional.useraccount;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;
import utilities.SharedData;

public class UserAccountSteps extends Steps {
    private SharedData sharedData;

    public UserAccountSteps(SharedData sharedData){
        this.sharedData =sharedData;
    }


    @When("I open user menu")
    public void whenIOpenUserMenu() {
        sharedData.homePage.openUserAccountMenu();
    }

    @Then("I verify that user name $name is displayed")
    public void thenIVerifyThatUserNameIsDisplayed(String userName) {
        String actualMessage = sharedData.userHomePage.greetMessage(userName);
        Assert.assertTrue(actualMessage.contains(userName));
    }
}
