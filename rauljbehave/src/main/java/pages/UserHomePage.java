package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHomePage extends LoadableComponent {
    private static final String USER_GREET_MESSAGE_XPATH = "//strong[contains(text(), 'Sicoie Raul')]";

    private WebDriver driver;
    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement account;


    @FindBy(xpath="//div[contains(@class, 'navbar-toolbox')]")
    private WebElement userMenuContainer;

    public UserHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUser() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(userMenuContainer));

        Actions action = new Actions(driver);
        action.moveToElement(account).build().perform();
        WebElement element = driver.findElement(By.xpath(USER_GREET_MESSAGE_XPATH));
        return element.getText();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
