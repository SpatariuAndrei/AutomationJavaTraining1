package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    @FindBy(css = "#start button")
    private WebElement startButton;
    private By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickStart() {
        startButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textMatches(loadedText, Pattern.compile("Hello World!")));
    }

    public String getLoadedText() {
        return driver.findElement(loadedText).getText();
    }

    public boolean verifyStartButton() {
        return startButton.isDisplayed();
    }
}
