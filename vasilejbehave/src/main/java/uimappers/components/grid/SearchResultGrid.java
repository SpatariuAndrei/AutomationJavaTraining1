package uimappers.components.grid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uimappers.utils.WebDriverUtilities;

import static driverprovider.DriverInstance.getDriver;
import static uimappers.constants.TimeoutConstants.DEFAULT_TIMEOUT;


public class SearchResultGrid extends BaseGrid {
    private WebDriverUtilities driverUtilities;
    private static final String PRODUCT_TITLE_XPATH = "//div[@class='card-section-mid']//h2//a[@title='%s']/../../..//div[contains(@class,'card-section-top')]//button[contains(@class,'add-to-favorites')]";

    @FindBy(xpath = "//div[@class='ns-content']//div[text()='Produsul a fost adaugat la Favorite']")
    private WebElement notification;


    public SearchResultGrid(){
        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public void clickFavoritesIcon(String product) {
        String favoritesIconXpath = String.format(PRODUCT_TITLE_XPATH, product);

        driverUtilities.waitForElementToBeClickable(By.xpath(favoritesIconXpath), DEFAULT_TIMEOUT);
        WebElement element = getDriver().findElement(By.xpath(favoritesIconXpath));
        element.click();

        driverUtilities.waitForElementToBeClickable(notification, DEFAULT_TIMEOUT);
    }
}
