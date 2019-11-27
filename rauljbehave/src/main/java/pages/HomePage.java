package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class HomePage extends LoadableComponent {

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    @FindBy(id = "searchboxTrigger")
    private WebElement searchBar;
    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement enterAccount;
    @FindBy(xpath = "//nav[@id='masthead']")
    private WebElement horizontalMenuContainer;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyFile = new DataFromPropertyFile();

    }

    public SearchPage searchProduct(String product) {
        searchBar.sendKeys(product);
        searchButton.click();
        return new SearchPage(driver);
    }

    public LoginPage navigateToLoginPage() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(enterAccount));
        enterAccount.click();
        return new LoginPage(driver);
    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagPage(), driver.getCurrentUrl());
    }
}
