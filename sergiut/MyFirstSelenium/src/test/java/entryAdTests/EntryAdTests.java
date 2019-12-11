package entryAdTests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EntryAdPage;

import static org.testng.Assert.assertEquals;

/**
 * WIP
 */

public class EntryAdTests extends BaseTests {

    @Test
    public void testCloseAd() {
        EntryAdPage adPage = homePage.clickEntryAdPage();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        String expectedResult = "It's commonly used to encourage a user to take an action (e.g., give their e-mail " + "address to sign up for something or disable their ad blocker).";
        String actualResult = adPage.getAdMessage();
        adPage.closeAd();
        assertEquals(actualResult,expectedResult,"No Add as expected");
    }
}
