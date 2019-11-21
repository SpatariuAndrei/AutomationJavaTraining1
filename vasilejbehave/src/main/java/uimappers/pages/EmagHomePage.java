package uimappers.pages;

import properties.PropertiesConfig;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.constants.UserMenuOptions;
import utilities.SharedData;

import static properties.PropertiesKeys.HOME_ADDRESS;
import static properties.PropertiesKeys.PERSONAL_DATA;

public class EmagHomePage {
    private SharedData share;

    private TopHorizontalMenu topHorizontalMenu;
    private LoginPage loginPage;
    private WishListPage wishListPage;
    private UserMenu userMenu;

    public EmagHomePage(SharedData share){
        this.share = share;

        topHorizontalMenu = new TopHorizontalMenu(share);
        userMenu = new UserMenu(share);
        wishListPage = new WishListPage(share);
    }

    public LoginPage navigateToLoginPage() {
        loginPage = topHorizontalMenu.clickOnLoginButton();
        return loginPage;
    }

    public UserMenu openUserAccountMenu() {
        return topHorizontalMenu.openUserMenu();
    }

    public WishListPage navigateToWishListPage() {
        wishListPage = topHorizontalMenu.clickOnFavorite();
        return wishListPage;
    }

    public void logout(UserMenuOptions userMenuOption) {
        userMenu.clickOnOption(userMenuOption.getUserMenuOptionValue());
        String currentUrl = share.driver.getCurrentUrl();

        // need to try again due to emag pop-up
        if (!currentUrl.equals(PropertiesConfig.getProperty(HOME_ADDRESS))) {
            String baseUrl = PropertiesConfig.getProperty(HOME_ADDRESS);
            String personalDataUrl = PropertiesConfig.getProperty(PERSONAL_DATA);
            share.driver.get(baseUrl + personalDataUrl);
            openMenuForLogout();
            userMenu.clickOnOption(userMenuOption.getUserMenuOptionValue());
        }
    }

    private void openMenuForLogout() {
        topHorizontalMenu.openUserMenuForLogout();
    }
}
