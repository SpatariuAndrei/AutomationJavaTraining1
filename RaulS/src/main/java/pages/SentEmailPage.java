package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentEmailPage {

    private WebDriver driver;

    @FindBy(id = "content")
    private WebElement emailStatus;

     SentEmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAlertText() {
        return emailStatus.getText();
    }
}
