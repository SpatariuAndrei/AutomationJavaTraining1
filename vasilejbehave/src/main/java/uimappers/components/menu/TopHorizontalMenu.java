package uimappers.components.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.pages.LoginPage;
import uimappers.pages.SearchResultsPage;
import uimappers.pages.WishListPage;
import uimappers.utils.WebDriverUtilities;


import static driverprovider.DriverInstance.getDriver;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;
import static uimappers.constants.TimeoutConstants.MIN_TIMEOUT;

public class TopHorizontalMenu {

    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//nav[@id='masthead']")
    private WebElement horizontalMenuContainer;

    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='my_account']//i[@class='caret']")
    private WebElement userMenuIcon;

    @FindBy(xpath = "//a[(@id ='emg-user-menu')]//i")
    private WebElement logoutMenuIcon;

    @FindBy(xpath = "//a[(@id ='emg-user-menu')]")
    private WebElement userHomePageElement;

    @FindBy(xpath = "//a[@id ='my_wishlist']")
    private WebElement userFavoritePageElement;

    @FindBy(xpath = "//input[@id = 'searchboxTrigger']")
    private WebElement searchBar;

    @FindBy(xpath = "//div[@class='input-group-btn']//button[contains(@class,'searchbox-submit-button')]")
    private WebElement searchButton;

    public TopHorizontalMenu() {

        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickOnLoginButton() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        loginButton.click();

        return new LoginPage();
    }

    public UserMenu openUserMenu() {
        driverUtilities.waitForElementToBeClickable(userMenuIcon, MIN_TIMEOUT);
        Actions action = new Actions(getDriver());
        action.moveToElement(userMenuIcon).build().perform();

        return new UserMenu();
    }

    public WishListPage openFavoritesPage() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        userFavoritePageElement.click();

        return new WishListPage();
    }

    public void search(String product){
        driverUtilities.waitForElementToBeClickable(searchBar, MIN_TIMEOUT);
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys(product);
        driverUtilities.waitForElementAttributeToContain(searchBar, "value", product, MIN_TIMEOUT);

        searchButton.click();
    }
}
