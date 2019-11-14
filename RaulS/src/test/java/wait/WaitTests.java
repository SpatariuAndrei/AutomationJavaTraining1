package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHiddenFirstExample() {
        DynamicLoadingExample1Page loadingExample1Page = homePage.clickDynamicLoading().clickDynamicExemple1();
        loadingExample1Page.clickStartButton();
        assertEquals(loadingExample1Page.getLoadedMessage(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void testWaitUntilHiddenSecondExample() {
        DynamicLoadingExample2Page loadingExample2Page = homePage.clickDynamicLoading().clickDynamicExemple2();
        loadingExample2Page.clickStartButton2();
        assertEquals(loadingExample2Page.getLoadedMessage2(), "Hello World!", "Loaded text is incorrect");
    }
}
