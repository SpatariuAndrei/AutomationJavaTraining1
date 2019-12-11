package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * WIP
 */

public class EntryAdPage {
    private WebDriver driver;
    @FindBy(xpath = "//p[contains(text(),'Close')]")
    private WebElement closeButton;
    @FindBy(xpath = "//p[contains(text(),\"It's commonly used to encourage a user to take an \")]")
    private WebElement addMessage;

    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAdMessage(){
        return addMessage.getText();
    }

    public void closeAd() {
        closeButton.click();
    }

}
