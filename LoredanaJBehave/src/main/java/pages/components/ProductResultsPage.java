package pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import utils.Constants;
import utils.Helper;
import utils.SharedData;
import utils.WebDriverUtilities;

public class ProductResultsPage {

    //*********Page Variables*********
    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    private Helper helper;
    //*********Web Elements*********
    @FindBy(xpath = "//div[@class='page-skin-inner']//div[1]//div[1]//div[1]//div[1]//div[2]//button[2]//i[1]")
    private WebElement addToFavoriteButton;
    @FindBy(xpath = "//div[@class='page-skin-inner']//div[1]//div[1]//div[1]//div[3]//div[3]//form[1]//button[1]")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='clearfix pad-btm-md']//div[3]//div[1]//div[1]//div[3]//div[2]//p[2]")
    private WebElement firstPrice;
    @FindBy(xpath = "//div[@class='page-container']//div[2]//div[1]//div[1]//div[3]//div[2]//p[2]")
    private WebElement secondPrice;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm btn-block']")
    private WebElement detailsButton;

    //*********Constructor*********
    public ProductResultsPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities();
        helper = new Helper(sharedData);
    }

    public void addToFavorite() {
        webDriverUtilities.waitForElementToBeClickable(addToFavoriteButton, Constants.TIMEOUT);
        addToFavoriteButton.click();
    }

    public void addToCart() {
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
        return helper.getText(firstPrice);
    }

    public String getSecondPrice() {
        webDriverUtilities.waitForElementToBeVisible(secondPrice, Constants.TIMEOUT);
        return helper.getText(secondPrice);
    }
}