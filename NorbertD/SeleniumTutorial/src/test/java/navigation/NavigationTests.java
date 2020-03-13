package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoadigPage().clickOnExample2Link();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testOpenAndSwitchDynamicLoadingPageExample2(){
        var dynamicLoadingExample2Page = homePage.clickDynamicLoadigPage().rightClickAndOpenInNewTabExample2Link();
        getWindowManager().switchToNewTab();
    }
}
