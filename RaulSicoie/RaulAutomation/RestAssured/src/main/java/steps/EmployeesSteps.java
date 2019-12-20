package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import request.Employees;
import request.base.BaseUrl;

import static org.testng.AssertJUnit.assertEquals;

public class EmployeesSteps extends Steps {

    @Given("I make a request to base url")
    public void requestToBaseUrl() {
        BaseUrl.setUpDummyRestApi();
    }

    @When("I add  <employee>")
    public void addEmployee(@Named("employee") String employee) {
        Employees.createUser(employee);
    }

    @Then("the response is $value")
    public void verifyResponse(int value) {
        int actualCode = Employees.getResponseCode();
        assertEquals(actualCode, value);
    }
}
