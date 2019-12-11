package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class EntryAdPage {
    private WebDriver driver;
    @FindBy(xpath = "//p[contains(text(),'Close')]")
    private WebElement closeButton;
    @FindBy(xpath = "//p[contains(text(),\"It's commonly used to encourage a user to take an \")]")
    private WebElement addMessage;
    private By text = By.className("modal-body");

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAdMessage() {
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.textMatches(text, Pattern.compile("It's commonly used to encourage a user to take an ")));
        return addMessage.getText();
    }

    public void closeAd() {
        closeButton.click();
    }
}
