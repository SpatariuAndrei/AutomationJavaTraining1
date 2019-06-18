import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class LogUtil {
    private static int i=0;
    private Logger LOG;

    public LogUtil(){
        LOG = LoggerFactory.getLogger(EmagTest.class);
    }

    public void takeScreenshot(){
        try{
            final File img = Selenium.takeScreenshot();
            FileUtils.copyFile(img, new File("./screenshot/img"+ (++i) +".jpg"));
        }catch (Exception e){
            LOG.error("could not capture screenshot");
            e.printStackTrace();
        }
    }

}
