package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedPage {
    private WebDriver driver;
    private final String LeftFrame = "frame-left";
    private final String TopFrame = "frame-top";
    private final String BottomFrame = "frame-bottom";
    @FindBy(tagName = "body")
    private WebElement body;

    public NestedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        return body.getText();
    }

    private void switchToMainFrame() {
        driver.switchTo().parentFrame();
    }
}
