package airporttests;

import Mileage.Mileage;
import airport.Passenger;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.junit.Assert.assertEquals;

public class BonusPolicy {
    private Passenger mike;
    private Passenger john;
    private Mileage mileage;

    @Given("we have a usual passenger with a mileage")
    public void givenWeHaveAUsualPassengerWithAMileage() {
        mike = new Passenger("Mike", false);
        mileage = new Mileage();
    }

    @When("the usual passenger travels <mileage1> and <mileage2> and <mileage3>")
    public void whenTheUsualPassengerTravelsMileageAndMileageAndMileage(@Named("mileage1") int mileage1, @Named(
            "mileage2") int mileage2, @Named("mileage3") int mileage3) {
        mileage.addMileage(mike, mileage1);
        mileage.addMileage(mike, mileage2);
        mileage.addMileage(mike, mileage3);
    }

    @Then("the bonus points of the usual passenger should be <points>")
    public void thenTheBonusPointsOfTheUsualPassengerShouldBePoints(@Named("points") int points) {
        mileage.calculateGivenPoints();
        assertEquals(points, mileage.getPassengerPointsMap().get(mike).intValue());
    }

    @Given("we have a VIP passenger with a mileage")
    public void givenWeHaveAVipPassengerWithAMileage() {
        john = new Passenger("John", true);
        mileage = new Mileage();
    }

    @When("the usual VIP travels <mileage1> and <mileage2> and <mileage3>")
    public void whenTheUsualVipTravelsMileageAndMileageAndMileage(@Named("mileage1") int mileage1, @Named(
            "mileage2") int mileage2, @Named("mileage3") int mileage3) {
        mileage.addMileage(john, mileage1);
        mileage.addMileage(john, mileage2);
        mileage.addMileage(john, mileage3);
    }

    @Then("the bonus points of the VIP passenger should be <points>")
    public void thenTheBonusPointsOfTheVipPassengerShouldBePoints(@Named("points") int points) {
        mileage.calculateGivenPoints();
        assertEquals(points, mileage.getPassengerPointsMap().get(john).intValue());
    }
}

