package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.constants.TimeConstants;
import pages.utils.WebDriverUtilities;
import utilities.scroll.Scroll;

public class SummaryOrderPage {

    @FindBy(xpath = "//div[@class='cart-summary-container']")
    private WebElement summaryContainer;

    @FindBy(css = "#summaryForm > div.emg-col12 > div > div.summary-total-container > div.total-price > span > span.money-int")
    private WebElement orderTotalPrice;

    @FindBy(xpath = "//div[@class='emg-cart-icon']")
    private WebElement cartButton;

    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
    private JavascriptExecutor js;

    public SummaryOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverUtilities = new WebDriverUtilities();
        js = (JavascriptExecutor) driver;
    }

    public String getTotalCostToPay() {
        driverUtilities.waitForElementToBeVisible(summaryContainer, TimeConstants.SHORT_TIMEOUT);
        return orderTotalPrice.getText();
    }

    public CartPage goToCartPage() {
        Scroll.scrollToElement(cartButton,driver);
        driverUtilities.waitForElementToBeClickable(cartButton, TimeConstants.SHORT_TIMEOUT);
        cartButton.click();
        return new CartPage(driver);
    }

}
