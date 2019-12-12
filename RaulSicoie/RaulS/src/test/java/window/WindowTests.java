package window;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;

import static org.testng.Assert.assertTrue;


public class WindowTests extends BaseTests {

    @Test
    public void testWindowTabs() {
        DynamicLoadingExample1Page buttonPage = homePage.clickDynamicLoading().rightClickOnExample1Link();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
