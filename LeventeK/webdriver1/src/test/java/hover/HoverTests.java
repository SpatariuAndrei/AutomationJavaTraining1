package hover;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTest {

    @Test
    public void testHoverUser1(){
        var hoverspage = homePage.clickHovers();
        var caption = hoverspage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed");
        assertEquals(caption.getTitle(), "name: user1");
        assertEquals(caption.getLinkText(), "View profile", "Caption linktext incorrect");
        assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");
    }



}
