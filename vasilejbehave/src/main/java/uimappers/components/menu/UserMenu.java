package uimappers.components.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.SharedData;

import static driverprovider.WaitDriverProvider.waitProvider;

public class UserMenu {
    private static final String USER_GREET_MESSAGE_XPATH = "//div[contains(@class, 'navbar-drop')]//p//strong[contains(text(), '%s')]";
    private static final String USER_MENU_OPTION_XPATH = "//div[@class = 'ph-dropdown-inner']//a[text()= '%s']";

    private SharedData share;

    @FindBy(xpath ="//div[contains(@class, 'navbar-drop')]")
    private WebElement userMenuContainer;

    public UserMenu(SharedData share) {
        this.share = share;
        PageFactory.initElements(share.driver, this);
    }

    public String getUserGreetMessage(String username) {
        waitProvider().until(ExpectedConditions.visibilityOf(userMenuContainer));

        // construct the xpath
        String userNameXpath = String.format(USER_GREET_MESSAGE_XPATH, username);
        WebElement userNameElement = userMenuContainer.findElement(By.xpath(userNameXpath));

        return userNameElement.getText();
    }

    public void clickOnOption(String userMenuOption) {
        waitProvider().until(ExpectedConditions.visibilityOf(userMenuContainer));

        String userMenuOptionXpath = String.format(USER_MENU_OPTION_XPATH, userMenuOption);
        WebElement userMenuOptionElement = userMenuContainer.findElement(By.xpath(userMenuOptionXpath));

        Actions action = new Actions(share.driver);
        action.moveToElement(userMenuOptionElement).perform();

        waitProvider().until(ExpectedConditions.elementToBeClickable(userMenuOptionElement));
        userMenuOptionElement.click();

        waitProvider().until(ExpectedConditions.invisibilityOf(userMenuOptionElement));
        //add logger: LOGGER.info(String.format("User was logged out"));
    }
}
