package bdd.utilities;

import driverprovider.DriverInstance;
import org.openqa.selenium.WebDriver;
import uimappers.pages.*;

public class SharedData {
    public WebDriver driver;
    public DriverInstance driverInstance;

    /**
     * pages
     */
    public EmagHomePage homePage;
    public LoginPage loginPage;
    public UserHomePage userHomePage;
    public SearchResultsPage resultsPage;
    public WishListPage wishListPage;
}
