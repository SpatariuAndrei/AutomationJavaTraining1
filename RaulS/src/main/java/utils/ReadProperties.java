package utils;

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
            String userPath = System.getProperty("user.dir");
            InputStream inputStream = new FileInputStream("src/main/resources/" + filename + ".properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Properties file not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can't read the properties file");
        }
    }

    public String getProperties(final String key) {
        return properties.getProperty(key);
    }
}
