package horizontalSlider;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class horizontalSliderTest extends BaseTests {

    @Test
    public void sliderTest(){
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderLink();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        horizontalSliderPage.clickHorizontalSlider();
        Assert.assertEquals(horizontalSliderPage.getRangeText(),"4" );


    }


}
