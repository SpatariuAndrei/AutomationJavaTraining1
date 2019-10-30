package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



/**
 * Created by cosmin.cirstea on 26.05.2018.
 */
public class ReadProperties {

    private final Properties properties;
    public static Logger logger= LoggerFactory.getLogger(ReadProperties.class);

    public ReadProperties(final String filename) {
        properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/test/resources/" + filename + ".properties");
            properties.load(input);
        } catch (final FileNotFoundException e) {
           logger.info("Properties file not found");
        } catch (final IOException e) {
            logger.info("Cannot read the properties file");
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }
}
