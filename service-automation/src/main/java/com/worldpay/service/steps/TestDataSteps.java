package com.worldpay.service.steps;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import com.worldpay.service.entities.SharedData;

public class TestDataSteps {

    private SharedData share;

    public TestDataSteps(SharedData share) {
        this.share = share;
    }

    /**
     * General, most frequently used, step to load properties tables.<br>
     * The table can be supplied directly in the story or by giving the name of the table file that contains the table.<br>
     * <br>
     * Eg.<br>
     * <br>
     * Given test data for someDescription:<br>
     * path/to/table/file/tableFile.table<br>
     * <br>
     * or<br>
     * <br>
     * Given test data for someDescription:<br>
     * | key | value |<br>
     * | firstKey | firstValue |<br>
     * ...
     */
    @Given("test data for $description: $propertiesTable")
    @Alias("table file for $description: $propertiesTable")
    @When("test data for $description: $propertiesTable")
    @Then("test data for $description: $propertiesTable")
    public void givenTestData(@Named("propertiesTable") ExamplesTable propertiesTable) {
        setTestData(propertiesTable);
    }

    @Given("test data cleared")
    @When("test data cleared")
    @Then("test data cleared")
    public void givenTestDataCleared() {
        share.getTestData().clear();
    }

    /**
     * Loads the properties from the given table.
     */
    private void setTestData(ExamplesTable propertiesTable) {
        for (Parameters row : propertiesTable.getRowsAsParameters(true)) {
            String key = row.valueAs("key", String.class);
            String value = row.valueAs("value", String.class);
            share.getTestData().setProperty(key, value);
        }
    }

}
