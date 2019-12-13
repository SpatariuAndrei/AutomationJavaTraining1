package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadEnvProperties {

    private static final String ENV_PROPERTIES_NAME = "env";
    private final Properties properties;

    private static final Logger logger = LoggerFactory.getLogger(ReadEnvProperties.class);

    public ReadEnvProperties() {
        properties = new Properties();

        try {
            InputStream inputStream = new FileInputStream("src/test/resources/" + ENV_PROPERTIES_NAME + ".properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            logger.error("Properties file not found" + e);
        } catch (IOException e) {
            logger.error("Cannot read the properties" + e);
        }
    }

    public String getEnvProperty(String key) {
        return properties.getProperty(key);
    }

}
