package javascript;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDomPage;

import static org.testng.Assert.assertTrue;


public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
        assertTrue(largeAndDeepDomPage.isTableVisible(), "Table does not exist");
    }

    @Test
    public void testToFifthParagraph() {
        int expectedParagraph = 5;
        InfiniteScrollPage scrollPage = homePage.clickInfiniteScroll();
        scrollPage.scrollToParagraph(expectedParagraph);
        assertTrue(scrollPage.isParagraphDisplayed(), expectedParagraph + " paragraph is not displayed");
    }
}
