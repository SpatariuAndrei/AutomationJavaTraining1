package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {

    WebDriver driver;
    @FindBy(xpath = "//input[@id='file-upload']")
    private WebElement inputField;
    @FindBy(xpath = "//input[@id='file-submit']")
    private WebElement uploadButton;

    FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UploadedFilePage clickUploadButton() {
        uploadButton.click();
        return new UploadedFilePage(driver);
    }

    public void uploadFile(String absolutePathOfFile) {
        inputField.sendKeys(absolutePathOfFile);
    }
}
