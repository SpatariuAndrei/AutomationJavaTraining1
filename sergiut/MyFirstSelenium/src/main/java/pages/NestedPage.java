package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedPage {
    private WebDriver driver;
    private final String LeftFrame = "frame-left";
    private final String TopFrame = "frame-top";
    private final String BottomFrame = "frame-bottom";
    private By body = By.tagName("body");

    public NestedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String switchLeftAreaText() {
        driver.switchTo().frame(TopFrame);
        driver.switchTo().frame(LeftFrame);
        String text = getFrameText();
        switchToMainFrame();
        switchToMainFrame();
        return text;
    }

    public String switchBottomAreaText() {
        driver.switchTo().frame(BottomFrame);
        String text = getFrameText();
        switchToMainFrame();
        return text;
    }

    public String getFrameText() {
        return driver.findElement(body).getText();
    }

    private void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }
}
