package fileUpload;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage uploadPage = homePage.clickFileUploadPage();
        String filePath = System.getProperty("user.dir") + "/resources/chromedriver.exe";
        uploadPage.uploadFile(filePath);
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded failed");
    }
}
