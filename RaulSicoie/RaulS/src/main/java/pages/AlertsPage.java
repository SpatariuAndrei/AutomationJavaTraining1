package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    private WebDriver driver;
    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    private WebElement triggerAlertButton;
    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    private WebElement triggerConfirmButton;
    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    private WebElement triggerPromptButton;
    @FindBy(id = "result")
    private WebElement alertResultText;

    AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void triggerAlert() {
        triggerAlertButton.click();
    }

    public void triggerConfirm() {
        triggerConfirmButton.click();
    }

    public void triggerPrompt() {
        triggerPromptButton.click();
    }

    public void alertClickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alertClickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public void alertSetPromptInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getAlertResult() {
        return alertResultText.getText();
    }

    public String alertConfirmGetText() {
        return driver.switchTo().alert().getText();
    }

}
