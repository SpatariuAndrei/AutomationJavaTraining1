package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void verifyTopAndBottomFramesText(){
        var nestedFrames = homePage.clickFrames();
        assertEquals(nestedFrames.getLeftFrameText(),"LEFT");
        assertEquals(nestedFrames.getBottomFrameText(),"BOTTOM");
    }
}
