package frame;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedPage;

import static org.testng.Assert.assertEquals;

public class NestedFrameTests extends BaseTests {

    @Test
    public void testNestedFrame() {
        FramesPage framesPage = homePage.clickFramesPage();
        NestedPage nestedPage = framesPage.SelectNestedFramePage();
        String left = nestedPage.switchLeftAreaText();
        String bottom = nestedPage.switchBottomAreaText();
        assertEquals(String.valueOf(left), "LEFT", "Different result!");
        assertEquals(String.valueOf(bottom), "BOTTOM", "Different result!");
    }
}
