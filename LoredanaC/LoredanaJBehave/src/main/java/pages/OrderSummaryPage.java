package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.*;

public class OrderSummaryPage {

    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;

    @FindBy(xpath = "//button[@class='emg-button emg-btn-huge btn-submit']")
    private WebElement sendOrderButton;

    public OrderSummaryPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities(sharedData);
    }

    public boolean verifyMessage() {
        webDriverUtilities.waitForElementToBeVisible(sendOrderButton, Constants.TIMEOUT);
        return sendOrderButton.isDisplayed();
    }
}
