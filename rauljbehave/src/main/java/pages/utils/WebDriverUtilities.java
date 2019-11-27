package pages.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static steps.setup.WaitDriverProvider.waitDrive;
import static steps.setup.WaitDriverProvider.waitProvider;


public class WebDriverUtilities {

    public void waitForElementToBeVisible(WebElement element, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element, int timeout){
        waitProvider(timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void meetExpectation(WebElement webElement, String property){
        waitDrive(webElement,property);
    }
}
