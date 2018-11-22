package com.worldpay.service.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

}
