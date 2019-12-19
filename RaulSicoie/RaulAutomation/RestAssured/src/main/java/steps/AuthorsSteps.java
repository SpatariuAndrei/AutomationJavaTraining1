package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import request.Authors;
import request.base.BaseUrl;

public class AuthorsSteps extends Steps {

    @Given("I make a request to base url")
    public void givenIGoToUrl() {
        BaseUrl.setUpFakeRestApi();
    }

    @Given("I provide the $param")
    public void giveParameters(String param) {
        Authors.setParam(param);
    }

    @When("I make the request I store the data in lists for every field")
    public void mappingTheData() {
        Authors.getAuthors();
    }

    @Then("I check that the name of authors contains the ID value")
    public void checkingAuthors() {
        Authors.runTests();
    }
}
