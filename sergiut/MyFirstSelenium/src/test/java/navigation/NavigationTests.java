package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoadingPage().clickExample1Page();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
        assertEquals(getWindowManager().getUrl(), "https://www.google.com/", "Not the expected page");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindowsPage().clickHere();
        getWindowManager().switchToTab("New Window");
        assertEquals(getWindowManager().getTabTitle(), "New Window", "Not the expected tab");
    }
}
