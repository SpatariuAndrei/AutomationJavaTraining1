package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.SharedData;
import utils.WebDriverUtilities;

public class CartPage {

    //*********Page Variables*********
    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    //*********Web Elements*********
    @FindBy(xpath = "//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")
    private WebElement deleteProductButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    private WebElement status;
    @FindBy(xpath = "//div[@class='emg-col3']//a[1]")
    private WebElement continuaButton;
    @FindBy(xpath = "//div[@class='emg-col3']//a[1]")
    private WebElement continueButton;

    //*********Constructor*********
    public CartPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities();
    }

    //*********Methods*********
    public void deleteProductFromCart() {
        webDriverUtilities.waitForElementToBeClickable(deleteProductButton, Constants.TIMEOUT);
    }

    public boolean isMessageDisplayed() {
        webDriverUtilities.waitForElementToBeVisible(status, Constants.TIMEOUT);
        return status.isDisplayed();
    }

    public OrderDetailsPage clickOnContinueButton() {
        webDriverUtilities.waitForElementToBeClickable(continueButton, Constants.TIMEOUT);
        continueButton.click();
        return new OrderDetailsPage(sharedData);
    }
}
