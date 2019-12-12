package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WysiwygEditorPage {

    private WebDriver driver;
    private final String editorIframeId = "mce_0_ifr";
    @FindBy(id = "tinymce")
    private WebElement textArea;
    @FindBy(css = "#mceu_12 button")
    private WebElement decreaseIndentButton;

    WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
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

    public String getTextFromEditor(){
        switchToEditArea();
        String text =  textArea.getText();
        switchToMainArea();
        return text;
    }

    public void decreaseIndentation(){
        decreaseIndentButton.click();;
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

}
