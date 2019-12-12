package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertTrue;

public class NavigationClass extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab() {
        homePage.navigateToHomePage();
        homePage.clickMultipleWindowsPage().clickHere();
        getWindowManager().switchToTab("New window");
    }

    @Test
    public void testStartButton() {
        DynamicLoadingExample2Page buttonPage = homePage.clickDynamicLoading().rightClickExample2();
        getWindowManager().switchToNewTab();
        assertTrue(buttonPage.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
