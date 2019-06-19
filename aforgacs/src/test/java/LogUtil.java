import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class LogUtil {
    private static int i=0, j=0;
    private Logger LOG;

    public LogUtil(){
        LOG = LoggerFactory.getLogger(EmagTest.class);
    }

    public void info(String s){
        LOG.info(s);
    }

    public void takeScreenshot(){
        try{
            final File img = Selenium.takeScreenshot();
            FileUtils.copyFile(img, new File("./screenshots/img"+ (++i) +".jpg"));
        }catch (Exception e){
            LOG.error("Could not capture screenshot");
            e.printStackTrace();
        }
    }

    public void takeFullScreenshot(WebDriver driver){
        Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 500, true).withName("fullScreenshot"+ (++j)).save();
    }

}
