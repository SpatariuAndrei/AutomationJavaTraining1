package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.constants.TimeConstants;
import pages.utils.WebDriverUtilities;

public class DetailsOrderPage {

    //1 Modalitate de livare
    @FindBy(xpath = "//div[@class='cart-checkout-step']")
    private WebElement deliveryWayContainer;

    @FindBy(xpath = "//li[@id='courierTab']")
    private WebElement courierDeliveryButton;

    @FindBy(xpath = "//div[@class='cart-widget courier-delivery']")
    private WebElement addressContainer;

    @FindBy(xpath = "//div[@id='courierDelivery']//li[1]")
    private WebElement selectAddressButton;

    //2 Date facturare
    @FindBy(xpath = "//div[@class='cart-widget pb10']")
    private WebElement billingContainer;

    @FindBy(xpath = "//li[@class='gui-tabs-button-custom selected']")
    private WebElement normalPerson;

    @FindBy(xpath = "//div[@id='billingPerson']//li[@class='line-item']//div[@class='line-content']")
    private WebElement billingAddressButton;

    //3 Modalitate de plata
    @FindBy(xpath = "//div[@class='cart-widget p20']")
    private WebElement payContainer;

    @FindBy(id = "paymentLinecard")
    private WebElement cardPaymentMethodButton;

    //Sumar comanda
    @FindBy(xpath = "//body[contains(@class,'cart-page')]/div[@id='emg-body-overlay']/" +
            "div[contains(@class,'emg-container')]/form[@id='checkoutForm']/div[@id='cartCheckoutPage']/" +
            "div[contains(@class,'emg-col9')]/div[6]")
    private WebElement totalCostContainer;

    @FindBy(xpath = "//button[contains(@class,'emg-button gtm_stj738bt emg-btn-large emg-btn-full')]")
    private WebElement nextStepButton;

    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
    private TimeConstants constants;
    private JavascriptExecutor js;

    public DetailsOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverUtilities = new WebDriverUtilities();
        js = (JavascriptExecutor) driver;
    }

    public void setDeliveryDetails() {
        driverUtilities.waitForElementToBeVisible(deliveryWayContainer, constants.SHORT_TIMEOUT);
        driverUtilities.waitForElementToBeClickable(courierDeliveryButton, constants.SHORT_TIMEOUT);
        courierDeliveryButton.click();
    }

    /**
     * We assume that the billing details :
     * Name, phone number and address,
     * were set before trying to run this test
     */
    public void setBillingDetails() {
        js.executeScript("window.scrollTo(0,700)");
    }

    public void payWayDetails() {
        js.executeScript("window.scrollTo(0,1270)");
        driverUtilities.waitForElementToBeVisible(payContainer, constants.SHORT_TIMEOUT);
        driverUtilities.waitForElementToBeClickable(cardPaymentMethodButton, constants.SHORT_TIMEOUT);
        cardPaymentMethodButton.click();
    }

    public SummaryOrderPage goToSummaryPage() {
        js.executeScript("window.scrollTo(0,1270)");
        driverUtilities.waitForElementToBeVisible(totalCostContainer, constants.SHORT_TIMEOUT);
        driverUtilities.waitForElementToBeClickable(nextStepButton, constants.SHORT_TIMEOUT);
        nextStepButton.click();
        return new SummaryOrderPage(driver);
    }


}
