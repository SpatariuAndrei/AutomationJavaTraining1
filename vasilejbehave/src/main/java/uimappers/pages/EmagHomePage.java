package uimappers.pages;

import properties.PropertiesConfig;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.constants.UserMenuOptions;
import uimappers.utils.WebDriverUtilities;

import static driverprovider.DriverInstance.getDriver;
import static properties.PropertiesKeys.*;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;

public class EmagHomePage {

    private TopHorizontalMenu topHorizontalMenu;
    private UserMenu userMenu;
    private WebDriverUtilities driverUtilities;

    public EmagHomePage() {


        topHorizontalMenu = new TopHorizontalMenu();
        userMenu = new UserMenu();
        driverUtilities = new WebDriverUtilities();
    }

    public LoginPage navigateToLoginPage() {
        return topHorizontalMenu.clickOnLoginButton();
    }

    public void openUserAccountMenu() {
        topHorizontalMenu.openUserMenu();
    }

    public void logout(UserMenuOptions userMenuOption) {
        try {
            topHorizontalMenu.openUserMenu();
            userMenu.clickOnOption(userMenuOption.getUserMenuOptionValue());
        } catch (org.openqa.selenium.json.JsonException | org.openqa.selenium.TimeoutException |org.openqa.selenium.NoSuchElementException e) {
            System.out.println("USER IS NOT A GOOD PAGE");
        } finally {

            // emag issue Log out button has a baseUri property - either remove that property with Javascript executor either this
            String currentUrl = getDriver().getCurrentUrl();
            if (!currentUrl.equals("www.emag.ro")) {
                System.out.println("LOG OUT");
                getDriver().get(PropertiesConfig.getProperty(LOGOUT_URL));
                driverUtilities.waitUntilPageIsLoaded(DEFAULT_TIMEOUT);
            }
        }
    }

}
