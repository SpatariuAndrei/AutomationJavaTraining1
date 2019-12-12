package uploads;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.UploadedFilePage;

import static org.testng.AssertJUnit.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void uploadFile() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();
        String filepath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        fileUploadPage.uploadFile(filepath);
        UploadedFilePage uploadedFilePage = fileUploadPage.clickUploadButton();
        assertEquals(uploadedFilePage.getResult(), "chromedriver.exe");
    }
}
