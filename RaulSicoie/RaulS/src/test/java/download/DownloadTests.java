package download;

import base.WgetTests;
import org.testng.annotations.Test;
public class DownloadTests extends WgetTests {

    @Test
    public void yahooDownloadTest(){
        downloadYahooPage.clickDownload();
    }
}
