package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    @FindBy(css = "#start button")
    private WebElement startButton;
    @FindBy(id = "loading")
    private WebElement loadingIndicator2;
    @FindBy(id = "finish")
    private WebElement textMessage;

    DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStartButton2() {
        startButton.click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(ExpectedConditions.class);
        wait.until(ExpectedConditions.invisibilityOf(loadingIndicator2));
    }

    public String getLoadedMessage2() {
        return textMessage.getText();
    }
}
