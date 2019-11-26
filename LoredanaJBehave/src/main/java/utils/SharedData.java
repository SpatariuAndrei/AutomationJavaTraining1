package utils;

import driverprovider.DriverInstance;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.EmagHomePage;
import pages.LoginPage;

public class SharedData {
    public WebDriver driver;
    public DriverInstance driverInstance;

    /**
     * pages
     */
    public EmagHomePage homePage;
    public LoginPage loginPage;
    public CartPage cartPage;
}
