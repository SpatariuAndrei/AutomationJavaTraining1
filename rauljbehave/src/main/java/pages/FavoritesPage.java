package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utilities.DataFromPropertyFile;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FavoritesPage extends LoadableComponent {


    @FindBy(xpath = "//div[@class='page-container']")
    private WebElement productContainer;

    @FindBy(id = "list-of-favorites")
    private WebElement container;

    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement myAccountButton;

    @FindBy(linkText = "Log out")
    private WebElement logOutButton;

    public static final String PRODUCT = ".//div[@class='product-card-account pad-sep-sm  ']";

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    private List<WebElement> favoriteProductList;


    @Override
    protected void load() {
        driver.get(propertyFile.getEmagFavoritesPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagFavoritesPage(), driver.getCurrentUrl());
    }

    public WebElement getContainer() {
        return container;
    }

    public FavoritesPage(WebDriver driver) {
        this.driver = driver;
        propertyFile = new DataFromPropertyFile();
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getItems() {
        List<WebElement> listOfItems = container.findElements(By.xpath(PRODUCT));
        return listOfItems;
    }

    public boolean getElements(String productName) {
        List<WebElement> elementList = getItems();
        for (WebElement element : elementList) {
            try {
                if (element.findElement(By.xpath("//span[contains(text(),'" + productName + "')]")).isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                System.out.println("Product not find!");
            }
        }
        return false;
    }

    public void logOut() {
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountButton).perform();
        logOutButton.click();
    }

}
