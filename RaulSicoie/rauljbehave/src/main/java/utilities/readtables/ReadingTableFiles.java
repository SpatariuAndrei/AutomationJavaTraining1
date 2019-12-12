package utilities.readtables;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DataFromPropertyFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadingTableFiles {

    private HashMap<String, String> dataMap;

    private static final Logger logger = LoggerFactory.getLogger(ReadingTableFiles.class);

    //read from text file and place into a map
    public HashMap<String, String> readDataTables(DataFromPropertyFile propertyFile) {
        dataMap = new HashMap<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(propertyFile.getUserPersonalDataPath()));
            reader.readLine(); //skip first line
            while ((line = reader.readLine()) != null) {
                line = line.substring(1, line.length() - 1); //cleaning the first | and last |
                String parts[] = splitLine(line);
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];
                    dataMap.put(key, value);
                } else {
                    logger.info("ignoring line:" + line);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            logger.error("File not found: " + e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return dataMap;
    }

    private String[] splitLine(String line) {
        String[] parts = new String[2];
        for (int i = 0; i <= line.length() - 1; i++) {
            if (line.charAt(i) == '|') {
                parts[0] = line.substring(0, i).trim();
                parts[1] = line.substring(i + 1).trim();
            }
        }
        return parts;
    }
}
