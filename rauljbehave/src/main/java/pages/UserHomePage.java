package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.constants.TimeConstants;
import pages.utils.WebDriverUtilities;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class UserHomePage extends LoadableComponent {

    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement account;

    @FindBy(linkText = "Log out")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[contains(@class, 'navbar-toolbox')]")
    private WebElement userMenuContainer;

    @FindBy(xpath = "//*[@id=\"emg-input-autosuggest\"]")
    private WebElement searchBar;

    @FindBy(css = "#emg-category-menu-icon")
    private WebElement searchButton;

    private static final String USER_GREET_MESSAGE_XPATH = "//strong[contains(text(), 'Sicoie Raul')]";

    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
    private DataFromPropertyFile propertyFile;
    private TimeConstants constants;

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverUtilities = new WebDriverUtilities();
        propertyFile = new DataFromPropertyFile();
    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagUserHomePage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagUserHomePage(), driver.getCurrentUrl());
    }

    public String getUser() {
        driverUtilities.waitForElementToBeVisible(userMenuContainer, constants.LONG_TIMEOUT);
        Actions action = new Actions(driver);
        action.moveToElement(account).build().perform();
        WebElement element = driver.findElement(By.xpath(USER_GREET_MESSAGE_XPATH));
        return element.getText();
    }

    public void logOut() {
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();
        logOutButton.click();
    }

    public SearchPage searchProduct(String product) {
        driverUtilities.waitForElementToBeVisible(searchBar, constants.LONG_TIMEOUT);
        searchBar.sendKeys(product);
        driverUtilities.waitForElementToBeClickable(searchButton, constants.LONG_TIMEOUT);
        searchButton.click();
        return new SearchPage(driver);
    }

    public UserHomePage goToUserHomePage() {
        return new UserHomePage(driver);
    }
}
