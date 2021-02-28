package Hoover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HooverPage;

public class HooverTests extends BaseTests {

    @Test
    public void hooverUser1Test(){
        HooverPage hooverPage = homePage.clickHooverLink();
       HooverPage.FigureCaption caption =  hooverPage.hooverOverFigure(1);
        Assert.assertTrue(caption.isCaptionDisplayed(),"Caption not displayed");
        Assert.assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        Assert.assertEquals(caption.getLinkText(),"View profile", "Caption link text is incorrect");
        Assert.assertTrue(caption.getLink().endsWith("/users/1"), "Link incorrect");



    }




}
