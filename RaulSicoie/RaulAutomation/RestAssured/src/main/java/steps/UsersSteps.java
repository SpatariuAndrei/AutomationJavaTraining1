package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import request.Users;
import request.base.BaseUrl;

import static org.testng.Assert.assertEquals;

public class UsersSteps extends Steps {

    @Given("I store the name of users with id $value in a string")
    public void getUserNames(int value) {
        BaseUrl.setUpFakeRestApi();
        Users.getUsers(value);
    }

    @Given("I insert a new user with id $value, username $name, password $pass")
    public void addNewUser(int value, String name, String pass) {
        Users.addUser(value, name, pass);
    }

    @When("I delete the user with id $value")
    public void deleteById(int value) {
        Users.deleteUser(value);
    }

    @Then("the request response code should be $code")
    public void thenTheRequestResponseCodeShouldBe(int code) {
        int actualValue = Users.getResponse();
        int expectedValue = code;
        assertEquals(actualValue, expectedValue);

    }
}
