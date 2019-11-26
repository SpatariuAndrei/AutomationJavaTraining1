package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Helper {

    //*********Variables*********
    private SharedData sharedData;

    //*********Constructor*********
    public Helper(SharedData sharedData) {
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
}
