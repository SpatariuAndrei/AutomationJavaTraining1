package driverprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.SharedData;

import static driverprovider.DriverInstance.getDriver;


public class WaitDriverProvider {
    private WaitDriverProvider() {
    }

    //TODO add timeout as parameter
    public static WebDriverWait waitProvider(int timeout) {
        return new WebDriverWait(getDriver(), timeout);
    }
}
