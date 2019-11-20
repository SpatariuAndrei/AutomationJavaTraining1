package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WYSIWYGEditorPage {

    WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    @FindBy(css = "#tinymce")
    private WebElement textArea;
    @FindBy(css = " #mceu_12 button")
    private WebElement decreaseIndentButton;

    WYSIWYGEditorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    public void clearTextArea() {
        switchToEditArea();
        textArea.clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        textArea.sendKeys(text);
        switchToMainArea();
    }

    public void decreaseIndention() {
        decreaseIndentButton.click();
    }

    public String getTextFromArea() {
        switchToEditArea();
        String text = textArea.getText();
        switchToMainArea();
        return text;
    }
}
