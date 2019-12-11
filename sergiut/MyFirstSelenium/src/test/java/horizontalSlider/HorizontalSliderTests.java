package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testSlider() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderPage();
        float desiredValue = 4.5f;
        horizontalSliderPage.moveSlider(desiredValue);
        assertEquals(String.valueOf(desiredValue), horizontalSliderPage.getValue());
    }
}
