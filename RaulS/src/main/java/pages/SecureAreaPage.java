package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecureAreaPage {

    private WebDriver driver;

    @FindBy(id = "flash")
    private WebElement statusAlert;

     SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAlertText() {
        return statusAlert.getText();
    }
}
