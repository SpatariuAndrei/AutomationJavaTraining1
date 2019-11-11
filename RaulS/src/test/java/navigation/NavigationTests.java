package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickDynamicExemple1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com/");
        assertEquals(driver.getCurrentUrl(),"https://www.google.com/","Navigated to a wrong page");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
        assertEquals(driver.getTitle(),"New Window","Page title is wrong");
    }
}
