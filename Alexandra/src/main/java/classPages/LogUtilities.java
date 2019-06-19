package classPages;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class LogUtilities {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public void takeScreenshot() throws IOException {
        try {
            final File screenshot = Selenium.takeScreenshot();
            final DateTime dateTime = new DateTime(DateTimeZone.UTC);
            FileUtils.copyFile(screenshot, new File("C:/webdrivers/" +dateTime.toString("yyyyMMdd_HHmmSS") + ".jpg"));
        } catch (final IOException e){
            logger.error("Could not capture screenshot. ");
        }
    }
}
