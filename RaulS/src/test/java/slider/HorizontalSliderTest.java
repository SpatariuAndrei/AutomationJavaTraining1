package slider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTest extends BaseTests {

    private static final String VALUE4 = "4";

    @Test
    public void testSlider4() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.setSliderValue(VALUE4);
        assertEquals(horizontalSliderPage.getSliderValue(), VALUE4, "Slider value is incorrect");
    }
}
