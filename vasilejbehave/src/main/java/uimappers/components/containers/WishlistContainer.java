package uimappers.components.containers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.constants.TimeoutConstants;
import uimappers.utils.WebDriverUtilities;

import java.util.List;

import static driverprovider.DriverInstance.getDriver;

public class WishlistContainer extends BaseContainer {

    private WebDriverUtilities driverUtilities;

    private static final String PROODUCT_CONTAINER_XPATH = "//div[@id='list-of-favorites']//div[contains(@class, 'product-card-account')]";
    private static final String PRODUCT_NAME_XPATH = "//h2//span[text()='%s']/../../../../../..";
    private static final String REMOVE_BTN_XPATH ="//div[contains(@class, 'card-secondary')]//button[contains(@class, 'remove-from-favorites')]";

    @FindBy(xpath = "//div[contains(@class, 'card-secondary')]//button[contains(@class, 'remove-from-favorites')]")
    private WebElement webElement;

    public WishlistContainer() {
        super();
        PageFactory.initElements(getDriver(), this);
        driverUtilities = new WebDriverUtilities();
    }

    public boolean checkIfProductIsPresent(String productName) {

        String titleXpath = String.format(PRODUCT_NAME_XPATH, productName);
        String productXpath = PROODUCT_CONTAINER_XPATH + titleXpath;
        WebElement element = getDriver().findElement(By.xpath(productXpath));

        return element.isDisplayed();
    }

    public void removeProductsFromWhishList() {
        List<WebElement> wishlistProducts = bodyContainer.findElements(By.xpath(PROODUCT_CONTAINER_XPATH));
        for(WebElement currentProduct :  wishlistProducts){
            WebElement removeBtn =  currentProduct.findElement(By.xpath(REMOVE_BTN_XPATH));
            driverUtilities.waitForElementToBeClickable(removeBtn, TimeoutConstants.MIN_TIMEOUT);
            removeBtn.click();
        }

    }

    public int wishlistSize(){
        List<WebElement> wishlistProducts = bodyContainer.findElements(By.xpath(PROODUCT_CONTAINER_XPATH));
        return wishlistProducts.size();
    }
}
