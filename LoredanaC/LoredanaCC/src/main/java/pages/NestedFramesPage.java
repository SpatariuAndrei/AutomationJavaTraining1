package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage {

    WebDriver driver;
    @FindBy(xpath = "//body[contains(text(),'LEFT')]")
    private WebElement leftFrame;
    @FindBy(xpath = "//div[@id='content']")
    private  WebElement middleFrame;
    @FindBy(xpath = "//body[contains(text(),'RIGHT')]")
    private WebElement rightFrame;
    @FindBy(xpath = "//body[contains(text(),'BOTTOM')]")
    private WebElement bottomFrame;

    NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTextFromBottomFrame() {
        driver.switchTo().frame("frame-bottom");
        String text = getFrameText(bottomFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getTextFromLeftFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String text = getFrameText(leftFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getTextFromRightFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        String text = getFrameText(rightFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getTextFromMiddleFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String text = getFrameText(middleFrame);
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getFrameText(WebElement webElement) {
        return webElement.getText();
    }
}
