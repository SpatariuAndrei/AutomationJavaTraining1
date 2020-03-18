package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilVisible(){
        var loadingPage = homePage.clickDynamicLoadigPage().clickOnExample2Link();
        loadingPage.clickOnStartButton();
        assertTrue(loadingPage.isTextPresent());
    }

}
