package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
    private final Properties properties;

    public ReadProperties(final String filename) {
        properties = new Properties();

        try {
            InputStream input = new FileInputStream("src/test/resources/" + filename + ".properties");
            properties.load(input);
        } catch (final FileNotFoundException e) {
            System.out.println("Properties file not found");
        } catch (final IOException e) {
            System.out.println("Cannot read the properties file");
        }
    }

    public String getProperty(final String key) {
        return properties.getProperty(key);
    }
}
