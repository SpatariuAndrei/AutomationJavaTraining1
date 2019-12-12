package dynamicloadedpage;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DynamicLoadPageTests extends BaseTests {

    @Test
    public void testExample1() {
        DynamicLoadingExample1Page loadingPage = homePage.clickDynamicLoadingPage().clickExample1Page();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Test failed");
    }

    @Test
    public void testExample2() {
        DynamicLoadingExample2Page loadingPage = homePage.clickDynamicLoadingPage().clickExample2Page();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(), "Hello World!", "Test failed");
    }

    @Test
    public void testSwitchToNewTab() {
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingPage();
        DynamicLoadingExample2Page example2Page = dynamicLoadingPage.openExample2InNewTab();
        getWindowManager().switchToTabNo(1);
        assertTrue(example2Page.verifyStartButton(), "No Button");
    }
}
