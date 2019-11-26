package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class ReadProperties {

    //*********Variables*********
    private final Properties properties;
    public static Logger logger = LoggerFactory.getLogger(ReadProperties.class);

    //*********Constructor*********
    public ReadProperties(String filename) {
        properties = new Properties();
        String fileLocation = System.getProperty("user.dir") + "/src/main/resources/" + filename + ".properties";
        try {
            InputStream input = new FileInputStream(fileLocation);
            properties.load(input);
        } catch (final FileNotFoundException e) {
            logger.info("Properties file not found");
        } catch (final IOException e) {
            logger.info("Cannot read the properties file");
        }
    }

    //*********Methods*********
    public String getProperty(final String key) {
        return properties.getProperty(key);
    }
}