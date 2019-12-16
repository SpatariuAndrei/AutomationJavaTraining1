package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import request.GetAuthors;

public class AuthorsSteps extends Steps {

    @Given("I go to url")
    public void givenIGoToUrl() {
        GetAuthors.setUp();
    }

    @Given("I provide the $param")
    public void giveParameters(String param) {
        GetAuthors.setParam(param);
    }

    @When("I make the request I store the data in lists for every field")
    public void mappingTheData() {
        GetAuthors.getAuthors();
    }

    @Then("I check that the name of authors contains the ID value")
    public void checkingAuthors() {
        GetAuthors.runTests();
    }
}
