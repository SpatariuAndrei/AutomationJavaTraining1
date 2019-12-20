package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileUploadPage {
    private WebDriver driver;
    @FindBy(id = "file-upload")
    private WebElement inputField;
    @FindBy(id = "file-submit")
    private WebElement uploadButton;
    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickUploadButton() {
        uploadButton.click();
    }

    /**
     * Provides path of file to the form then clicks Upload button
     * @param absolutePathOfFile The complete path of the file to upload
     */
    public void uploadFile(String absolutePathOfFile) {
        inputField.sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFiles() {
        return uploadedFiles.getText();
    }
}
