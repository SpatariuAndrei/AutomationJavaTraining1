package pages.dynamicloadingpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingExample2Page {

    WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By text = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnStartButton(){
        driver.findElement(startButton).click();
        WebDriverWait wait = new WebDriverWait (driver, 6);
        wait.until(ExpectedConditions.presenceOfElementLocated(text));
    }

    public boolean isTextPresent(){
        return driver.findElement(text).isDisplayed();
    }
}
