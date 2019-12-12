package horizontalSliders;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void checkValue() {
        int sliderValue = 4;
        HorizontalSliderPage sliderPage = homePage.clickHorizontalSlider();
        sliderPage.sendKeys(sliderValue);
        assertEquals(sliderPage.getValue(), Integer.toString(sliderValue), "The value of slider is 4!");
    }
}
