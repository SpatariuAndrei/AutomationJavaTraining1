package hover;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(),"Not displayed");
        assertEquals(caption.getTitle(),"name: user1","Title not the same!");
        assertEquals(caption.getLinkText(),"View profile","LinkText not the same!");
        assertTrue(caption.getLink().endsWith(("/users/1")));
    }
}
