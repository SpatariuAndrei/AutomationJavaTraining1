package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    @FindBy(xpath = "//a[@id='emg-user-menu']")
    private WebElement myAccountButton;

    @FindBy(linkText = "Log out")
    private WebElement logOutButton;

    @FindBy(xpath = "//div[@class='cart-widget cart-line']")
    private WebElement container;

    @FindBy(xpath = "//div[@class='emg-col3']//a[1]")
    private WebElement continueButton;

    private static final String PRODUCT = "//div[@class='line-item main-product']";

    private WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

     void logOut() {
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

    public List<String> getElementsFromCart() {
        List<String> productsNameFromCart = new ArrayList<>();
        List<WebElement> elementList = getItems();
        for (WebElement element : elementList) {
            try {
                productsNameFromCart.add(element.getText());
            } catch (Exception e) {
                logger.info("Product not find in cart!");
            }
        }
        return productsNameFromCart;
    }

    public DetailsOrderPage goToOrderDetailsPage(){
        continueButton.click();
        return new DetailsOrderPage(driver);
    }

    public static void clean(SharedData sharedData, DataFromPropertyFile propertyFile ){
        CartPage cartPage = PageFactory.initElements(sharedData.driver, CartPage.class);
        if (!(sharedData.driver.getCurrentUrl().equals(propertyFile.getEmagCartPage()))) {
            sharedData.driver.navigate().to(propertyFile.getEmagCartPage());
        }

        try {
            cartPage.getContainer();
            for (WebElement item : cartPage.getItems()) {
                item.findElement(By.xpath("//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")).click();
            }
        } catch (Exception e) {

        }
        cartPage.logOut();
    }

}
