package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SharedData;

public class PageLoadHelper {

    SharedData sharedData;

    public static PageLoadHelper isLoaded() {
        return new PageLoadHelper();
    }

    public PageLoadHelper isElementIsClickable(By by) {
        try {
            new WebDriverWait(sharedData.driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not clickable");
        }
    }

    public PageLoadHelper isElementIsVisible(By by) {
        try {
            new WebDriverWait(sharedData.driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element is not visible");
        }
    }
}
