package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import utilities.SharedData;

import static junit.framework.TestCase.assertTrue;

public class PlaceOrderSteps extends Steps {

    private SharedData sharedData;

    public PlaceOrderSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I found first product")
    public void whenIFoundFirstProduct() {
        sharedData.productPage = sharedData.searchPage.foundFirstProduct();
    }

    @Given("I press Continua")
    public void givenIPressContinua() {
        sharedData.detailsOrderPage = sharedData.cartPage.goToOrderDetailsPage();
    }

    @Given("I set the order details")
    public void givenISetTheOrderDetails() {
        sharedData.detailsOrderPage.setDeliveryDetails();
        sharedData.detailsOrderPage.setBillingDetails();
        sharedData.detailsOrderPage.payWayDetails();
    }

    @When("I pres Pasul Urmator")
    public void whenIPresPasulUrmator() {
        sharedData.summaryOrderPage = sharedData.detailsOrderPage.goToSummaryPage();
    }

    @Then("I verify that message Total Comanda has an amount of money")
    public void verifyAmountOfMoney() {
        String currentValue = sharedData.summaryOrderPage.getTotalCostToPay();
        assertTrue(currentValue != null);
    }
}
