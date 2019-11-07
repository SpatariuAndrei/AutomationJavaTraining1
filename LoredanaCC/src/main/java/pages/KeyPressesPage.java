package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KeyPressesPage {

    private WebDriver driver;

    @FindBy(id = "target")
    private WebElement inputField;
    @FindBy(id = "result")
    private WebElement resultText;

    KeyPressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterText(String text) {
        inputField.sendKeys(text);
    }

    public void enterPi() {
        enterText(Keys.chord(Keys.ALT, "p") + "=3.14");
    }

    public String getResult() {
        return resultText.getText();
    }
}
