package utilities;

import driverprovider.DriverInstance;
import org.openqa.selenium.WebDriver;
import uimappers.pages.EmagHomePage;
import uimappers.pages.LoginPage;

public class SharedData {
    public WebDriver driver;
    public DriverInstance driverInstance;

    /**
     * pages
     */
    public EmagHomePage homePage;
    public LoginPage loginPage;
}
