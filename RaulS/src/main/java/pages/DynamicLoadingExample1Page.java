package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample1Page {

    private WebDriver driver;
    @FindBy(css = "#start button")
    private WebElement startButton;
    @FindBy(id = "loading")
    private WebElement loadingIndicator;
    @FindBy(id = "finish")
    private WebElement textMessage;

    DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStartButton() {
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5); //explicit wait is only for this method not all the app
        wait.until(ExpectedConditions.invisibilityOf(loadingIndicator));
    }

    public String getLoadedMessage() {
        return textMessage.getText();
    }
}
