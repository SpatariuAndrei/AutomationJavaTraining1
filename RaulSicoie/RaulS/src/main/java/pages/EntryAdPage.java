package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntryAdPage {

    private WebDriver driver;
    @FindBy(xpath = "//p[contains(text(),'Close')]")
    private WebElement closeButton;
    @FindBy(xpath = "//p[contains(text(),\"It's commonly used to encourage a user to take an\")]")
    private WebElement modalMessage;

    EntryAdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getModalMassage() {
        return modalMessage.getText();
    }

    public void closeModal() {
        closeButton.click();
    }
}
