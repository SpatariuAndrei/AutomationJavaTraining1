package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

    WebDriver driver;
    @FindBy(id = "email")
    private WebElement emailTextField;
    @FindBy(xpath = "//button[@id='form_submit']")
    private WebElement retrievePasswordBtn;

    ForgotPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterEmail(String email) {
        emailTextField.sendKeys(email);
    }

    public EmailPage clickRetrievePassword() {
        retrievePasswordBtn.click();
        return new EmailPage(driver);
    }
}
