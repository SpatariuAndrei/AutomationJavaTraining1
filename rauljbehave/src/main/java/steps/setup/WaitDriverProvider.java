package steps.setup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.setup.Browser.getDriver;

public class WaitDriverProvider {

    private WaitDriverProvider() {
    }

    public static  WebDriverWait waitProvider(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }

    public static Boolean waitDrive(WebElement webElement, String property){
        return new WebDriverWait(getDriver(),10).until(ExpectedConditions.attributeContains(webElement,"value",property));
    }
}
