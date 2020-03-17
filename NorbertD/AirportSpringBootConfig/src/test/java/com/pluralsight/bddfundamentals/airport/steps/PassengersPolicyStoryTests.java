package com.pluralsight.bddfundamentals.airport.steps;

import com.pluralsight.bddfundamentals.airport.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@Component
public class PassengersPolicyStoryTests {
    private Flight economyFlight;
    private Flight businessFlight;
    private Flight premiumFlight;
    private Passenger notVIPMike;
    private Passenger vipJohn;

    @Given("there is an economy flight")
    public void givenThereIsAnEconomyFlight() {
        economyFlight = new EconomyFlight("1");
    }

    @When("we have a usual passenger")
    public void whenWeHaveAUsualPassenger() {
        notVIPMike = new Passenger("Mike", false);
    }

    @Then("you can add and remove him from an economy flight")
    public void thenYouCanAddAndRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a usual passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(notVIPMike)),
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue(economyFlight.getPassengerSet().contains(notVIPMike)),
                () -> assertEquals(true, economyFlight.removePassenger(notVIPMike)),
                () -> assertEquals(0, economyFlight.getPassengerSet().size())
        );
    }

    @When("we have a VIP passenger")
    public void whenWeHaveAVipPassenger() {
        vipJohn = new Passenger("John", true);
    }

    @Then("you can add him but cannot remove him from an economy flight")
    public void thenYouCanAddHimButCannotRemoveHimFromAnEconomyFlight() {
        assertAll("Verify all conditions for a VIP passenger and an economy flight",
                () -> assertEquals("1", economyFlight.getId()),
                () -> assertEquals(true, economyFlight.addPassenger(vipJohn)),
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue( economyFlight.getPassengerSet().contains(vipJohn)),
                () -> assertEquals(false, economyFlight.removePassenger(vipJohn)),
                () -> assertEquals(1, economyFlight.getPassengerSet().size())
        );
    }

    @Given("there is an business flight")
    public void givenThereIsAnBusinessFlight() {
        businessFlight = new BusinessFlight("2");
    }

    @Then("you cannot add or remove him from a business flight")
    public void thenYouCannotAddOrRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a usual passenger and a business flight",
                () -> assertEquals(false, businessFlight.addPassenger(notVIPMike)),
                () -> assertEquals(0, businessFlight.getPassengerSet().size()),
                () -> assertEquals(false, businessFlight.removePassenger(notVIPMike)),
                () -> assertEquals(0, businessFlight.getPassengerSet().size())
        );
    }

    @Then("you can add him but cannot remove him from a business flight")
    public void thenYouCanAddHimButCannotRemoveHimFromABusinessFlight() {
        assertAll("Verify all conditions for a VIP passenger and a business flight",
                () -> assertEquals(true, businessFlight.addPassenger(vipJohn)),
                () -> assertEquals(1, businessFlight.getPassengerSet().size()),
                () -> assertEquals(false, businessFlight.removePassenger(vipJohn)),
                () -> assertEquals(1, businessFlight.getPassengerSet().size())
        );
    }

    @Given("there is an premium flight")
    public void givenThereIsAnPremiumFlight() {
        premiumFlight = new PremiumFlight("3");
    }

    @Then("you cannot add or remove him from a premium flight")
    public void thenYouCannotAddOrRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a usual passenger and a premium flight",
                () -> assertEquals(false, premiumFlight.addPassenger(notVIPMike)),
                () -> assertEquals(0, premiumFlight.getPassengerSet().size()),
                () -> assertEquals(false, premiumFlight.removePassenger(notVIPMike)),
                () -> assertEquals(0, premiumFlight.getPassengerSet().size())
        );
    }

    @Then("you can add and remove him from a premium flight")
    public void thenYouCanAddAndRemoveHimFromAPremiumFlight() {
        assertAll("Verify all conditions for a VIP passenger and a premium flight",
                () -> assertEquals(true, premiumFlight.addPassenger(vipJohn)),
                () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                () -> assertEquals(true, premiumFlight.removePassenger(vipJohn)),
                () -> assertEquals(0, premiumFlight.getPassengerSet().size())
        );
    }

    @Then("you cannot add a usual passenger to an economy flight more than once")
    public void thenYouCannotAddAUsualPassengerToAnEconomyFlightMoreThanOnce() {
        for (int i=0; i<10; i++) {
            economyFlight.addPassenger(notVIPMike);
        }
        assertAll("Verify a usual passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue(economyFlight.getPassengerSet().contains(notVIPMike)),
                () -> assertTrue(new ArrayList<>(economyFlight.getPassengerSet()).get(0).getName().equals("Mike"))
        );
    }

    @Then("you cannot add a VIP passenger to an economy flight more than once")
    public void thenYouCannotAddAVipPassengerToAnEconomyFlightMoreThanOnce() {
        for (int i=0; i<10; i++) {
            economyFlight.addPassenger(vipJohn);
        }

        assertAll("Verify a VIP passenger can be added to an economy flight only once",
                () -> assertEquals(1, economyFlight.getPassengerSet().size()),
                () -> assertTrue(economyFlight.getPassengerSet().contains(vipJohn)),
                () -> assertTrue(new ArrayList<>(economyFlight.getPassengerSet()).get(0).getName().equals("John"))
        );
    }

    @Then("you cannot add a VIP passenger to a business flight more than once")
    public void thenYouCannotAddAVipPassengerToABusinessFlightMoreThanOnce() {
        for (int i=0; i<10; i++) {
            businessFlight.addPassenger(vipJohn);
        }

        assertAll("Verify a VIP passenger can be added to a business flight only once",
                () -> assertEquals(1, businessFlight.getPassengerSet().size()),
                () -> assertTrue(businessFlight.getPassengerSet().contains(vipJohn)),
                () -> assertTrue(new ArrayList<>(businessFlight.getPassengerSet()).get(0).getName().equals("John"))
        );
    }

    @Then("you cannot add a VIP passenger to a premium flight more than once")
    public void thenYouCannotAddAVipPassengerToAPremiumFlightMoreThanOnce() {
        for (int i=0; i<10; i++) {
            premiumFlight.addPassenger(vipJohn);
        }

        assertAll("Verify a VIP passenger can be added to a premium flight only once",
                () -> assertEquals(1, premiumFlight.getPassengerSet().size()),
                () -> assertTrue(premiumFlight.getPassengerSet().contains(vipJohn)),
                () -> assertTrue(new ArrayList<>(premiumFlight.getPassengerSet()).get(0).getName().equals("John"))
        );
    }
}
