package driverprovider;

import org.openqa.selenium.support.ui.WebDriverWait;

import static driverprovider.DriverInstance.getDriver;

public class WaitDriverProvider {
    private WaitDriverProvider() {
    }

    public static WebDriverWait setExplicitDriverProvider() {
        return new WebDriverWait(getDriver(), 20);
    }
}
