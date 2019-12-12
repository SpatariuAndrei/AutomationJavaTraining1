package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementHelper;

public class FramesPage {

    private WebDriver driver;
    private WebElementHelper helper;

    FramesPage(WebDriver driver) {
        helper = new WebElementHelper(driver);
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFrames() {
        helper.clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }
}
