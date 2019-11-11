package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NestedFramesPage;

import static org.testng.Assert.assertEquals;

public class FramesTests extends BaseTests {

    @Test
    public void verifyFrames() {
        NestedFramesPage nestedFramesPage = homePage.clickFrames().clickNestedFramesPage();
        String leftText = "LEFT";
        String rightText = "RIGHT";
        String bottomText = "BOTTOM";
        String middleText = "MIDDLE";
        assertEquals(nestedFramesPage.getTextFromLeftFrame(), leftText, "Incorrect text in left frame");
        assertEquals(nestedFramesPage.getTextFromRightFrame(), rightText, "Incorrect text in right frame");
        assertEquals(nestedFramesPage.getTextFromBottomFrame(), bottomText, "Incorrect text in bottom frame");
        assertEquals(nestedFramesPage.getTextFromMiddleFrame(), middleText, "Incorrect text in middle frame");
    }
}
