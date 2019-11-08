package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void TestNestedFrameText(){
        NestedFramesPage nestedFramesPage = homePage.clickFrames().clickNestedFrames();

        assertEquals(nestedFramesPage.getLeftFrameText(),"LEFT","Left frame text is incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(),"BOTTOM","Bottom frame text is incorrect");
    }

}
