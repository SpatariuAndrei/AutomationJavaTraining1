package driverprovider;

import org.openqa.selenium.support.ui.WebDriverWait;

import static driverprovider.DriverInstance.getDriver;

public class WaitDriverProvider {
    private WaitDriverProvider() {
    }

    //TODO add timeout as parameter
    public static WebDriverWait waitProvider() {
        return new WebDriverWait(getDriver(), 20);
    }
}
