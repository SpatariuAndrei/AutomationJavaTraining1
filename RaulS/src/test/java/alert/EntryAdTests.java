package alert;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EntryAdPage;

import static org.testng.Assert.assertEquals;

public class EntryAdTests extends BaseTests {

    @Test
    public void testEntryAd() {
        EntryAdPage entryAdPage = homePage.clickEntryAd();
        String actualMessage = entryAdPage.getModalMassage();
        String expectedMessage  = "It's commonly used to encourage a user to take an action (e.g., give their e-mail " +
                "address to sign up for something or disable their ad blocker).";
        entryAdPage.closeModal();
        assertEquals(actualMessage, expectedMessage, "Modal message is not the same");
    }
}
