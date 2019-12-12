package utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private final Properties properties;

    private static final Logger logger = LoggerFactory.getLogger(ReadProperties.class);

    public ReadProperties(final String filename) {
        properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/test/resources/" + filename + ".properties");
            properties.load(input);
        } catch (final FileNotFoundException e) {
            logger.error("Properties file not found" + e);
        } catch (final IOException e) {
            logger.error("Cannot read the properties file" + e);
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }
}
