package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import request.EmployeesNames;
import request.base.BaseUrl;

import static org.testng.AssertJUnit.assertTrue;

public class EmployeesNameSteps extends Steps {

    @Given("I go to base url")
    public void getRequest() {
        BaseUrl.setUpDummyRestApi();
    }

    @When("I extract the response")
    public void getTheResponse() {
        EmployeesNames.getUsers();
    }

    @Then("I verify $person is an employee")
    public void verifyForEmployee(String person) {
        assertTrue(EmployeesNames.getName().contains(person));
    }
}
