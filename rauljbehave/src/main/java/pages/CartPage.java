package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public class CartPage extends LoadableComponent {

    private WebDriver driver;
    public static final String PRODUCT = "//div[@class='line-item main-product']";
    @FindBy(xpath = "//a[@id='emg-user-menu']")
    private WebElement myAccountButton;
    @FindBy(linkText = "Log out")
    private WebElement logOutButton;
    @FindBy(xpath = "//div[@class='cart-widget cart-line']")
    private WebElement container;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logOut() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountButton).perform();
        logOutButton.click();
    }

    public WebElement getContainer() {
        return container;
    }

    public List<WebElement> getItems() {
        List<WebElement> listOfItems = container.findElements(By.xpath(PRODUCT));
        return listOfItems;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }


}
