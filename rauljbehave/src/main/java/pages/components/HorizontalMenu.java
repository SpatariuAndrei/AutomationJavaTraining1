package pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.utils.WebDriverUtilities;
import utilities.SharedData;

public class HorizontalMenu {

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

    public HorizontalMenu(SharedData share) {
        this.share = share;
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(share.driver, this);
    }

    public LoginPage clickOnLoginButton() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, 30);
        loginButton.click();

        return new LoginPage(share.driver);
    }
}
