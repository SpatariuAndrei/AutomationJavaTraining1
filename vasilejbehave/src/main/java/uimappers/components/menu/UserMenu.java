package uimappers.components.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.utils.WebDriverUtilities;

import static driverprovider.DriverInstance.*;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;
import static uimappers.constants.TimeoutConstants.MIN_TIMEOUT;

public class UserMenu {
    private static final String USER_GREET_MESSAGE_XPATH = "//div[contains(@class, 'navbar-drop')]//p//strong[contains(text(), '%s')]";
    private static final String USER_MENU_OPTION_XPATH = "//a[text()= '%s']";

    private WebDriverUtilities driverUtilities;

    @FindBy(xpath = "//div[contains(@class, 'ph-dropdown-inner')]")
    private WebElement userMenuContainer;

    public UserMenu() {
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public String getUserGreetMessage(String username) {
        driverUtilities.waitForElementToBeVisible(userMenuContainer, DEFAULT_TIMEOUT);

        // construct the xpath
        String userNameXpath = String.format(USER_GREET_MESSAGE_XPATH, username);
        WebElement userNameElement = userMenuContainer.findElement(By.xpath(userNameXpath));

        return userNameElement.getText();
    }

    public void clickOnOption(String userMenuOption) {
        String userMenuOptionXpath = String.format(USER_MENU_OPTION_XPATH, userMenuOption);
        driverUtilities.waitForElementToBeVisible(By.xpath(userMenuOptionXpath), MIN_TIMEOUT);
        WebElement userMenuOptionElement = getDriver().findElement(By.xpath(userMenuOptionXpath));

        Actions action = new Actions(getDriver());
        action.moveToElement(userMenuOptionElement).perform();

        driverUtilities.waitForElementToBeClickable(userMenuOptionElement, MIN_TIMEOUT);
        userMenuOptionElement.click();
    }
}
