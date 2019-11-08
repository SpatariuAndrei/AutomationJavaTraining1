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
        fileUploadPage.uploadFile("C:/Users/lcoroama/Downloads/chromedriver_win32/chromedriver.exe");
        UploadedFilePage uploadedFilePage = fileUploadPage.clickUploadButton();
        assertEquals(uploadedFilePage.getResult(), "chromedriver.exe");
    }
}
