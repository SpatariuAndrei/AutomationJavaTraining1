package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pageObjects.PcGarageLoginSignUpPage;
import pageObjects.PcGarageSearchResultsPage;

public class SharedMethods {

    SharedData sharedData;

    public SharedMethods(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public void type(WebElement input, String text) {
        input.sendKeys(text);
    }

    public WebElement find(By locator) {
        return sharedData.driver.findElement(locator);
    }


    public void moveToAndClick(WebElement e) {
        Actions action = new Actions(sharedData.driver);
        action.moveToElement(e).build().perform();
        e.click();
    }

}
