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
    private WebElement uploadFileButton;
    @FindBy(id = "uploaded-files")
    private WebElement uploadedFiles;

    FileUploadPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void uploadFile(String absolutePathOfFile) {
        inputField.sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public void clickUploadButton() {
        uploadFileButton.click();
    }



    public String getUploadedFiles() {
        return uploadedFiles.getText();
    }


}
