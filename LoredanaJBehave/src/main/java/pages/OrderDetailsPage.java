package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.*;

public class OrderDetailsPage {

    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    private JavascriptExecutor js;

    @FindBy(xpath = "//div[@class='emg-col3']//a[1]")
    private WebElement continueButton;
    @FindBy(xpath = "//li[@id='courierTab']//div[@class='tab-btn-inner']")
    private WebElement livrarePrinCurier;
    @FindBy(xpath = "//span[contains(text(),'Ramburs la curier')]")
    private WebElement rambursLaCurier;
    @FindBy(xpath = "//button[@class='emg-button gtm_stj738bt emg-btn-large emg-btn-full']")
    private WebElement nextStep;

    public OrderDetailsPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities(sharedData);
        js = (JavascriptExecutor) sharedData.driver;
    }

    public void selectLivrarePrinCurier() {
        webDriverUtilities.waitForElementToBeClickable(livrarePrinCurier, Constants.TIMEOUT);
        livrarePrinCurier.click();
    }

    public void selectRambursLaCurier() {
        js.executeScript("window.scrollTo(0,900)");
        webDriverUtilities.waitForElementToBeClickable(rambursLaCurier, Constants.TIMEOUT);
        rambursLaCurier.click();
    }

    public OrderSummaryPage clickOnPasulUrmator() {
        webDriverUtilities.waitForElementToBeClickable(nextStep, Constants.TIMEOUT);
        nextStep.click();
        return new OrderSummaryPage(sharedData);
    }
}
