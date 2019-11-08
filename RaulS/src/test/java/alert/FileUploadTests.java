package alert;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:/Work/cld_automation_community/RaulS/src/main/resources/chromedriver.exe");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploading file failed!");

    }
}
