package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaScriptAlertsPage {
    private WebDriver driver;
    @FindBy(xpath = ".//button[text()='Click for JS Alert']")
    private WebElement triggerAlertButton;
    @FindBy(xpath = ".//button[text()='Click for JS Confirm']")
    private WebElement triggerConfirmButton;
    @FindBy(xpath = ".//button[text()='Click for JS Prompt']")
    private WebElement triggerPromptButton;
    @FindBy(id = "result")
    private WebElement result;

    public JavaScriptAlertsPage(WebDriver driver) {
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

    public void alert_clickToAccept() {
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText() {
        return driver.switchTo().alert().getText();
    }

    public void alert_setInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public String getResult() {
        return result.getText();
    }
}
