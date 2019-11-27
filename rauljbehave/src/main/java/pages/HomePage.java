package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.components.HorizontalMenu;
import pages.constants.TimeConstants;
import pages.utils.WebDriverUtilities;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

import static org.junit.Assert.assertEquals;

public class HomePage extends LoadableComponent {

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement enterAccount;

    @FindBy(xpath = "//nav[@id='masthead']")
    private WebElement horizontalMenuContainer;

    private SharedData sharedData;
    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    private WebDriverUtilities driverUtilities;
    private TimeConstants constants;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyFile = new DataFromPropertyFile();
        driverUtilities =  new WebDriverUtilities();
    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagPage(), driver.getCurrentUrl());
    }

    public SearchPage searchProduct(String product) {
        driverUtilities.waitForElementToBeVisible(searchBar, constants.LONG_TIMEOUT);
        searchBar.sendKeys(product);
        driverUtilities.waitForElementToBeClickable(searchButton, constants.LONG_TIMEOUT);
        searchButton.click();
        return new SearchPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        driverUtilities.waitForElementToBeClickable(enterAccount, constants.LONG_TIMEOUT);
        enterAccount.click();
        return new LoginPage(driver);
    }
}
