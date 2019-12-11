package dynamicLoadedPage;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertEquals;

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
}
