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
    private WebElement startButton;
    @FindBy(id = "loading")
    private WebElement loadingIndicator;
    @FindBy(id = "finish")
    private WebElement loadedText;

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStart() {
        startButton.click();
//        Or you can use this lines instead of FluentWait
//        WebDriverWait wait= new WebDriverWait(driver,5);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }

    public String getLoadedText() {
        return loadedText.getText();
    }
}
