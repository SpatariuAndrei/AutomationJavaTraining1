package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    WebDriver driver;
    @FindBy(xpath = "//div[@id='hot-spot']")
    private WebElement whiteBox;

    ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnBox() {
        Actions actions = new Actions(driver);
        actions.contextClick(whiteBox).perform();
    }

    public boolean verifyModalText(String text) {
        if (driver.switchTo().alert().getText().equals(text)) {
            clickOkButton();
            return true;
        }
        return false;
    }

    public void clickOkButton() {
        driver.switchTo().alert().accept();
    }
}
