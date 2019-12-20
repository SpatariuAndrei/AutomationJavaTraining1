package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.ALT;
import static org.openqa.selenium.Keys.chord;

public class KeyPressesPage {
    private WebDriver driver;
    @FindBy(id = "target")
    private WebElement inputField;
    @FindBy(id = "result")
    private WebElement resultText;

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterText(String text) {
        inputField.sendKeys(text);
    }

    public void enterPi() {
        enterText(chord(ALT, "π") + "=3.14");
    }

    public String getResult() {
        return resultText.getText();
    }
}
