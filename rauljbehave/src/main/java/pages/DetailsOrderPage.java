package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.utils.WebDriverUtilities;
import utilities.constants.TimeConstants;
import utilities.scroll.Scroll;

public class DetailsOrderPage {

    //1 Modalitate de livare

    @FindBy(xpath = "//li[@id='courierTab']")
    private WebElement courierDeliveryButton;

    //3 Modalitate de plata

    @FindBy(id = "paymentLinecard")
    private WebElement cardPaymentMethodButton;

    @FindBy(xpath = "//button[contains(@class,'emg-button gtm_stj738bt emg-btn-large emg-btn-full')]")
    private WebElement nextStepButton;

    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
    private JavascriptExecutor js;

    DetailsOrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverUtilities = new WebDriverUtilities();
        js = (JavascriptExecutor) driver;
    }

    public void setDeliveryDetails() {
        driverUtilities.waitForElementToBeClickable(courierDeliveryButton, TimeConstants.SHORT_TIMEOUT);
        courierDeliveryButton.click();
    }

    /**
     * We assume that the billing details :
     * Name, phone number and address,
     * were set before trying to run this test
     */
    public void payWayDetails() {
        Scroll.scrollToElement(cardPaymentMethodButton, driver);
        driverUtilities.waitForElementToBeClickable(cardPaymentMethodButton, TimeConstants.SHORT_TIMEOUT);
        cardPaymentMethodButton.click();
    }

    public SummaryOrderPage goToSummaryPage() {
        Scroll.scrollToElement(nextStepButton, driver);
        driverUtilities.waitForElementToBeClickable(nextStepButton, TimeConstants.SHORT_TIMEOUT);
        nextStepButton.click();
        return new SummaryOrderPage(driver);
    }


}
