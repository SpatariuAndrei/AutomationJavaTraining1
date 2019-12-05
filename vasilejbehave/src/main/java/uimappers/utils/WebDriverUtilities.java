package uimappers.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.SharedData;

import static driverprovider.WaitDriverProvider.waitProvider;

public class WebDriverUtilities {

    public WebDriverUtilities() {
    }

    public void waitForElementToBeClickable(WebElement element, int timeout){
        waitProvider(timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By by, int timeout){
        waitProvider(timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisible(WebElement element, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementToBeVisible(By by, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToDisappear(WebElement element, int timeout){
        waitProvider(timeout).until(ExpectedConditions.invisibilityOf(element));
    }

    public void  waitForElementAttributeToContain(WebElement element, String attribute, String expectedAttributeValue, int timeout){
        waitProvider(timeout).until(ExpectedConditions.attributeContains(element,attribute, expectedAttributeValue));
    }

    public void waitUntilPageIsLoaded(int timeout){
        waitProvider(timeout) .until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
