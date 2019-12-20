package utils;

import driverprovider.DriverInstance;
import org.openqa.selenium.WebDriver;
import pages.*;
import pages.ProductResultsPage;

public class SharedData {
    public WebDriver driver;
    public DriverInstance driverInstance;

    /**
     * pages
     */
    public EmagHomePage homePage;
    public LoginPage loginPage;
    public CartPage cartPage;
    public FavoritesPage favoritesPage;
    public ProductResultsPage productResultsPage;
    public OrderSummaryPage orderSummaryPage;
    public OrderDetailsPage orderDetailsPage;
}
