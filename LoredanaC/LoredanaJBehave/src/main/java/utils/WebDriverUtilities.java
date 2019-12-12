package utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

import static driverprovider.WaitDriverProvider.waitProvider;

public class WebDriverUtilities {

    //*********Variables*********
    private SharedData sharedData;

    //*********Constructor*********
    public WebDriverUtilities(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    //*********Methods*********
    public void setText(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    public void moveOverElement(WebElement webElement) {
        Actions actions = new Actions(sharedData.driver);
        actions.moveToElement(webElement);
    }

    public boolean isFieldCompleted(WebElement webElement) {
        return webElement.getText() != null;
    }

    public LinkedHashMap<String, String> getDataFromFile(String filePath) throws IOException {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        reader.readLine();
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split("\\|");
            if (parts.length >= 2)
            {
                String key =  StringUtils.deleteWhitespace(parts[1]);
                String value =  StringUtils.deleteWhitespace(parts[2]);
                map.put(key, value);
            } else {
                System.out.println("ignoring line: " + line);
            }
        }
        reader.close();
        return map;
    }
    public void waitForElementToBeClickable(WebElement element, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(By by, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeVisible(WebElement element, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeVisible(By by, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToDisappear(WebElement element, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementAttributeToContain(WebElement element, String attribute, String expectedAttributeValue, int timeout) {
        waitProvider(timeout).until(ExpectedConditions.attributeContains(element, attribute, expectedAttributeValue));
    }

    public void waitUntilPageIsLoaded(int timeout) {
        waitProvider(timeout).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
