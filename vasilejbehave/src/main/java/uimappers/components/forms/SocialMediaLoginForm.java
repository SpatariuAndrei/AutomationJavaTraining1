package uimappers.components.forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import uimappers.pages.UserHomePage;
import uimappers.utils.WebDriverUtilities;
import utilities.SharedData;

import java.util.Set;

import static driverprovider.DriverInstance.getDriver;
import static uimappers.constants.TimeoutConstants.*;

public class SocialMediaLoginForm {

    private Set windowHandles;
    private WebDriverUtilities driverUtilities;

    private static final String GOOGLE_EMAIL_FIELD_XPATH = "//input[@id='identifierId']";
    private static final String GOOGLE_NEXT_BUTTON_XPATH = "//div[@role='button']//span[text()='Înainte']";
    private static final String GOOGLE_PASSWORD_FIELD = "input[type=password]";

    private SharedData share;
    @FindBy(xpath = "//div[@id='view_container']")
    private WebElement googleLoginForm;

    public SocialMediaLoginForm() {

        driverUtilities = new WebDriverUtilities();
        PageFactory.initElements(getDriver(), this);
    }

    public void googleEmailAccount(String googleEmail) {
        // connect to facebook opens a new window in the same tab, in addition to the login popup.
        // Store all opened window handles
        windowHandles = share.driver.getWindowHandles();
        // Switch focus to the second opened window (which doesn't have a title)
        share.driver.switchTo().window((String) windowHandles.toArray()[1]);

        driverUtilities.waitForElementToBeClickable(By.xpath(GOOGLE_EMAIL_FIELD_XPATH), DEFAULT_TIMEOUT);
        WebElement googleAddress = share.driver.findElement(By.xpath(GOOGLE_EMAIL_FIELD_XPATH));
        googleAddress.click();
        googleAddress.clear();
        googleAddress.sendKeys(googleEmail);

        // wait for value to be displayed in input field
        driverUtilities.waitForElementAttributeToContain(googleAddress, "value", googleEmail, VALUE_TIMEOUT);
    }

    public void pressNextGoogleButtonForPassword() {
        driverUtilities.waitForElementToBeClickable(By.xpath(GOOGLE_NEXT_BUTTON_XPATH), DEFAULT_TIMEOUT);
        WebElement googleNextButton = share.driver.findElement(By.xpath(GOOGLE_NEXT_BUTTON_XPATH));
        googleNextButton.click();
    }

    public void googlePassword(String googlePassword) {
        WebElement googlePasswordField = share.driver.findElement(By.cssSelector(GOOGLE_PASSWORD_FIELD));
        googlePasswordField.click();
        googlePasswordField.clear();
        googlePasswordField.sendKeys(googlePassword);

        // wait for value to be displayed in input field
        driverUtilities.waitForElementAttributeToContain(googlePasswordField, "value", googlePassword, VALUE_TIMEOUT);
    }

    public UserHomePage pressNextGoogleLogin() {
        driverUtilities.waitForElementToBeClickable(By.xpath(GOOGLE_NEXT_BUTTON_XPATH), DEFAULT_TIMEOUT);
        WebElement googleNextButton = share.driver.findElement(By.xpath(GOOGLE_NEXT_BUTTON_XPATH));
        googleNextButton.click();

        // switch back to the original window
        share.driver.switchTo().window((String) windowHandles.toArray()[0]);
        driverUtilities.waitUntilPageIsLoaded(PAGE_LOADING_TIMEOUT);

        return new UserHomePage();
    }
}