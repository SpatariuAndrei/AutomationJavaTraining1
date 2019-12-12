package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    private WebDriver driver;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "form_submit")
    private WebElement retrievePasswordButton ;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }

    public EmailSentPage retrievePassword() {
        retrievePasswordButton.click();
        return new EmailSentPage(driver);
    }
}
