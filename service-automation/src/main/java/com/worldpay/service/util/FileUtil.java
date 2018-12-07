package com.worldpay.service.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtil {

    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    
    /**
     * 
     * @param filePath
     *            (Ex: src/main/resources/data/file.txt)
     * @return path to the specific project directory (Ex: /home/username/git/automation/src/main/resources/data/file.txt)
     */

    public static String buildResourcesPath(String filePath) {
        String absolutePath1 = new File(".").getAbsolutePath();
        String absolutePath = absolutePath1.substring(0, absolutePath1.length() - 1);
        String finalPath = absolutePath + PATH_TO_RESOURCES + filePath;
        return finalPath;
    }
    
    /**
     * Method to read Json from file to a string 
     * 
     * @param filePath
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public static String readJsonFromFile(String filePath) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(filePath));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.toJSONString();
    }
    
    /**
     * Reads the contents of a file, line by line, eliminating from the resulting lines multiple consecutive empty ones. Consecutive empty
     * lines are replaced with a single empty line. A line is considered empty even if it contains white space characters.
     */
    public static List<String> readFileWithoutMultipleEmptyLines(Path file) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            List<String> resultLines = new ArrayList<>();
            boolean previousLineWasEmpty = false;
            String line;
            while ((line = reader.readLine()) != null) {
                boolean currentLineIsEmpty = StringUtils.isBlank(line);
                if (!currentLineIsEmpty || !previousLineWasEmpty) {
                    resultLines.add(line);
                }
                previousLineWasEmpty = currentLineIsEmpty;
            }
            return resultLines;
        }
    }

}
