package uimappers.components.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import uimappers.utils.WebDriverUtilities;
import utilities.SharedData;

import static driverprovider.WaitDriverProvider.waitProvider;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;

public class UserMenu {
    private static final String USER_GREET_MESSAGE_XPATH = "//div[contains(@class, 'navbar-drop')]//p//strong[contains(text(), '%s')]";
    private static final String USER_MENU_OPTION_XPATH = "//div[@class = 'ph-dropdown-inner']//a[text()= '%s']";

    private SharedData share;
    private WebDriverUtilities driverUtilities;

    @FindBy(xpath ="//div[contains(@class, 'navbar-drop')]")
    private WebElement userMenuContainer;

    public UserMenu(SharedData share) {
        this.share = share;
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(share.driver, this);
    }

    public String getUserGreetMessage(String username) {
        driverUtilities.waitForElementToBeVisible(userMenuContainer, DEFAULT_TIMEOUT);

        // construct the xpath
        String userNameXpath = String.format(USER_GREET_MESSAGE_XPATH, username);
        WebElement userNameElement = userMenuContainer.findElement(By.xpath(userNameXpath));

        return userNameElement.getText();
    }

    public void clickOnOption(String userMenuOption) {
        driverUtilities.waitForElementToBeVisible(userMenuContainer, DEFAULT_TIMEOUT);

        String userMenuOptionXpath = String.format(USER_MENU_OPTION_XPATH, userMenuOption);
        WebElement userMenuOptionElement = userMenuContainer.findElement(By.xpath(userMenuOptionXpath));

        Actions action = new Actions(share.driver);
        action.moveToElement(userMenuOptionElement).perform();

        driverUtilities.waitForElementToBeClickable(userMenuOptionElement, DEFAULT_TIMEOUT);
        userMenuOptionElement.click();

        driverUtilities.waitForElementToDisappear(userMenuOptionElement, DEFAULT_TIMEOUT);
        //add logger: LOGGER.info(String.format("User was logged out"));
    }
}
