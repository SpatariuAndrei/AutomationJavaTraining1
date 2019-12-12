package javaScript;

import base.BaseTests;
import org.testng.annotations.Test;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDoomPage().scrollToTable();
    }

    @Test
    public void testScrollToIndex() {
        homePage.clickInfintieScrollPage().scrollToParagraph(7);
    }
}
