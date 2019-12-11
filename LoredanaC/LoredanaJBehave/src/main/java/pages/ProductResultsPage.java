package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.SharedData;
import utils.WebDriverUtilities;

public class ProductResultsPage {

    //*********Page Variables*********
    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    private JavascriptExecutor js;
    //*********Web Elements*********
    @FindBy(xpath = " (//*[contains(@class,'em em-fav gtm_xik37z')])[1]")
    private WebElement addToFavoriteButton;
    @FindBy(xpath = "(//*[contains(@class,'yeahIWantThisProduct')])[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "(//*[contains(@class,'product-new-price')])[1]")
    private WebElement firstPrice;
    @FindBy(xpath = "(//*[contains(@class,'product-new-price')])[2]")
    private WebElement secondPrice;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm btn-block']")
    private WebElement detailsButton;

    //*********Constructor*********
    public ProductResultsPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities(sharedData);
        js = (JavascriptExecutor) sharedData.driver;
    }

    public void addToFavorite() {
        js.executeScript("window.scrollTo(0,150)");
        webDriverUtilities.waitForElementToBeVisible(addToFavoriteButton, Constants.TIMEOUT);
        webDriverUtilities.waitForElementToBeClickable(addToFavoriteButton, Constants.TIMEOUT);
        addToFavoriteButton.click();
    }

    public void addToCart() {
        js.executeScript("window.scrollTo(0,150)");
        webDriverUtilities.waitForElementToBeClickable(addToCartButton, Constants.TIMEOUT);
        addToCartButton.click();
    }

    public CartPage clickOnCartDetails() {
        webDriverUtilities.waitForElementToBeClickable(detailsButton, Constants.TIMEOUT);
        detailsButton.click();
        return new CartPage(sharedData);
    }

    public String getFirstPrice() {
        webDriverUtilities.waitForElementToBeVisible(firstPrice, Constants.TIMEOUT);
        return webDriverUtilities.getText(firstPrice);
    }

    public String getSecondPrice() {
        webDriverUtilities.waitForElementToBeVisible(secondPrice, Constants.TIMEOUT);
        return webDriverUtilities.getText(secondPrice);
    }
}