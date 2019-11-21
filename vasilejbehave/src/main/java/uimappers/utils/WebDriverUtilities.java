package uimappers.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.SharedData;

import static driverprovider.WaitDriverProvider.waitProvider;

public class WebDriverUtilities {


    public WebDriverUtilities() {
    }

    public void waitForElementToDisappear(WebElement element){
        waitProvider().until(ExpectedConditions.invisibilityOf(element));
    }
}
