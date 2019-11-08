package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    @FindBy(css = "#start button")
    WebElement startButton;
    @FindBy(id = "loading")
    WebElement loadingIndicator;
    @FindBy(id = "finish")
    WebElement loadedText;

    DynamicLoadingExample1Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickStart() {
        startButton.click();
        FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }

    public String getLoadedText() {
        return loadedText.getText();
    }
}
