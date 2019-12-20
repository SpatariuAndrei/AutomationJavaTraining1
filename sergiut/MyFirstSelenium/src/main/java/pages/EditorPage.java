package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditorPage {
    private WebDriver driver;
    private final String editorIframeId = "mce_0_ifr";
    @FindBy(id = "tinymce")
    private WebElement textArea;
    @FindBy(css = "#mceu_12 button")
    private WebElement decreaseIndentButton;

    public EditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    public void ClearTextArea() {
        switchToEditArea();
        textArea.clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        textArea.sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = textArea.getText();
        switchToMainArea();
        return text;
    }

    public void DecreaseIndentation() {
        decreaseIndentButton.click();
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

}
