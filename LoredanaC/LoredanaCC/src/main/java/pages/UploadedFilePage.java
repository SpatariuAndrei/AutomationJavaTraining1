package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadedFilePage {

    WebDriver driver;
    @FindBy(xpath = "//div[@id='uploaded-files']")
    private WebElement result;

    UploadedFilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getResult() {
        return result.getText();
    }
}
