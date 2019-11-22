package uimappers.components.menu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.pages.LoginPage;
import uimappers.pages.WishListPage;
import uimappers.utils.WebDriverUtilities;
import utilities.SharedData;


import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;

public class TopHorizontalMenu {
    private SharedData share;
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

    public TopHorizontalMenu(SharedData share) {
        this.share = share;
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(share.driver, this);
    }

    public LoginPage clickOnLoginButton() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        loginButton.click();

        return new LoginPage(share);
    }

    public UserMenu openUserMenu() {
        Actions action = new Actions(share.driver);
        action.moveToElement(userMenuIcon).perform();

        return new UserMenu(share);
    }

    public UserMenu openUserMenuForLogout() {
        Actions action = new Actions(share.driver);
        action.moveToElement(logoutMenuIcon).perform();

        return new UserMenu(share);
    }

    public WishListPage clickOnFavorite() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, DEFAULT_TIMEOUT);
        userFavoritePageElement.click();

        return new WishListPage(share);
    }
}
