package bdd.steps.functional.wishlist;

import bdd.utilities.SharedData;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

public class WishlistSteps extends Steps {

    private SharedData sharedData;

    public WishlistSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("I verify that $product was added to my wishlist")
    public void thenIVerifyThatProductWasAddedToMyWishlist(@Named("product") String product) {
        Assert.assertTrue(sharedData.wishListPage.checkIfProductIsPresent(product));
    }
}
