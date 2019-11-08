package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPage {

    WebDriver driver;
    @FindBy(linkText = "Nested Frames")
    WebElement nestedFrames;

    FramesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public NestedFramesPage clickNestedFramesPage() {
        nestedFrames.click();
        return new NestedFramesPage(driver);
    }
}
