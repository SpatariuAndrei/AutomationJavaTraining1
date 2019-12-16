package pages;

import org.openqa.selenium.WebDriver;
import utils.WindowManager;

public class FramesPage {
    private WebDriver driver;
    private WindowManager windowManager;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
        windowManager = new WindowManager(driver);
    }

    public NestedPage SelectNestedFramePage() {
        windowManager.clickLink("Nested Frames");
        return new NestedPage(driver);
    }
}
