package uimappers.pages;

import driverprovider.DriverInstance;
import properties.PropertiesConfig;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.constants.UserMenuOptions;
import uimappers.utils.WebDriverUtilities;
import utilities.SharedData;

import static properties.PropertiesKeys.*;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;

public class EmagHomePage {
    private SharedData sharedData;

    private TopHorizontalMenu topHorizontalMenu;
    private UserMenu userMenu;
    private WebDriverUtilities driverUtilities;

    public EmagHomePage(SharedData sharedData) {
        this.sharedData = sharedData;

        topHorizontalMenu = new TopHorizontalMenu();
        userMenu = new UserMenu();
        driverUtilities = new WebDriverUtilities();
    }

    public LoginPage navigateToLoginPage() {
        sharedData.loginPage = topHorizontalMenu.clickOnLoginButton();
        return sharedData.loginPage;
    }

    public void openUserAccountMenu() {
        topHorizontalMenu.openUserMenu();
    }

    public void logout(UserMenuOptions userMenuOption) {
        try {
            openUserAccountMenu();
            userMenu.clickOnOption(userMenuOption.getUserMenuOptionValue());
        } catch (org.openqa.selenium.TimeoutException|org.openqa.selenium.NoSuchElementException e) {
            System.out.println("USER IS NOT A GOOD PAGE");
        } finally {

            // emag issue Log out button has a baseUri property - either remove that property with Javascript executor either this
            String currentUrl = DriverInstance.getDriver().getCurrentUrl();
            if (!currentUrl.equals("www.emag.ro")) {
                sharedData.driver.get(PropertiesConfig.getProperty(LOGOUT_URL));
                driverUtilities.waitUntilPageIsLoaded(DEFAULT_TIMEOUT);
            }
        }
    }

}
