package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.SharedData;
import utils.WebDriverUtilities;

public class LoginPage {

    //*********Page Variables*********
    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    //*********Web Elements*********
    @FindBy(xpath = "//button[@class='gui-btn auth-btn-primary auth-submit']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    //*********Constructor*********
    public LoginPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities(sharedData);
    }

    //*********Methods*********
    public void enterEmail(String username) {
        webDriverUtilities.setText(email, username);
    }

    public void clickOnContinue() {
        continueButton.click();
    }

    public EmagHomePage clickOnContinue2() {
        webDriverUtilities.waitForElementToBeVisible(continueButton, Constants.TIMEOUT);
        continueButton.click();
        return new EmagHomePage(sharedData);
    }

    public void enterPassword(String pass) {
        webDriverUtilities.waitForElementToBeClickable(password, Constants.TIMEOUT);
        webDriverUtilities.setText(password, pass);
    }
}
