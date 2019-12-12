package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NestedFramesPage {

    private WebDriver driver;
    private final String TOP_FRAME = "frame-top";
    private final String BOTTOM_FRAME = "frame-bottom";
    private final String LEFT_FRAME = "frame-left";
    @FindBy(tagName = "body")
    private WebElement body;

    NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getFrameText() {
        return body.getText();
    }

    public String getLeftFrameText() {
        driver.switchTo().frame(TOP_FRAME);
        driver.switchTo().frame(LEFT_FRAME);
        String leftFrameText = getFrameText();
        driver.switchTo().parentFrame(); //exit left frame to top frame
        driver.switchTo().parentFrame(); //exit top frame to main frame
        return leftFrameText;
    }

    public String getBottomFrameText() {
        driver.switchTo().frame(BOTTOM_FRAME);
        String bottomFrameText = getFrameText();
        driver.switchTo().parentFrame(); //exit bottom frame to main frame
        return bottomFrameText;
    }


}
