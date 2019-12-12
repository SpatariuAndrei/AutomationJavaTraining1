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
}
