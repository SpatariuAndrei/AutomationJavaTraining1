package alert;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage uploadPage = homePage.clickFileUpload();
        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        uploadPage.uploadFile(filePath);
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploading file failed!");

    }
}
