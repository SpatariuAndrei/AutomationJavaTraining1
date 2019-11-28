package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.constants.TimeConstants;
import pages.utils.WebDriverUtilities;

public class SummaryOrderPage {

    @FindBy(xpath = "//div[@class='cart-summary-container']")
    private WebElement summaryContainer;

    @FindBy(css = "#summaryForm > div.emg-col12 > div > div.summary-total-container > div.total-price > span > span.money-int")
    private WebElement orderTotalPrice;

    @FindBy(xpath = "//div[@class='emg-cart-icon']")
    private WebElement cartButton;

    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
    private TimeConstants constants;
    private JavascriptExecutor js;

    public SummaryOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverUtilities = new WebDriverUtilities();
        js = (JavascriptExecutor) driver;
    }

    public String getTotalCostToPay() {
        driverUtilities.waitForElementToBeVisible(summaryContainer, constants.SHORT_TIMEOUT);
        return orderTotalPrice.getText();
    }

    public CartPage goToCartPage() {
        js.executeScript("window.scrollTo(0,0)");
        driverUtilities.waitForElementToBeClickable(cartButton, constants.SHORT_TIMEOUT);
        cartButton.click();
        return new CartPage(driver);
    }

}
