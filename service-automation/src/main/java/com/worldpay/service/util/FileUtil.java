package com.worldpay.service.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

    private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);

    private FileUtil() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * Reads the contents of a file into a String. The file is always closed.
     * 
     * @param xmlFileTemplate
     *            - The file to read, must not be {@code null}
     * @param encoding
     *            - The encoding to use, {@code null} means platform default
     * @return - the file contents, never {@code null}
     */

    public static String readFileToString(File xmlFileTemplate, String encoding) {
        try {
            return FileUtils.readFileToString(xmlFileTemplate, encoding);
        } catch (IOException e) {
            LOG.info("Error while reading from file", e);
        }
        return StringUtils.EMPTY;
    }

    public static String readProp(String file, String key) {

        Properties prop = new Properties();

        try {
            prop.load(ClassLoader.class.getResourceAsStream(file));

        } catch (IOException e) {
            LOG.info("Error while reading property", e);
        }

        return prop.getProperty(key);

    }

    /**
//     * Reads the contents of a file, line by line, eliminating from the resulting lines multiple consecutive empty ones. Consecutive empty
//     * lines are replaced with a single empty line. A line is considered empty even if it contains white space characters.
//     */
//    public static List<String> readFileWithoutMultipleEmptyLines(Path file) throws IOException {
//        try (BufferedReader reader = new BufferedReader(file, StandardCharsets.UTF_8)) {
//            List<String> resultLines = new ArrayList<>();
//            boolean previousLineWasEmpty = false;
//            String line;
//            while ((line = reader.readLine()) != null) {
//                boolean currentLineIsEmpty = StringUtils.isBlank(line);
//                if (!currentLineIsEmpty || !previousLineWasEmpty) {
//                    resultLines.add(line);
//                }
//                previousLineWasEmpty = currentLineIsEmpty;
//            }
//            return resultLines;
//        }
//    }

    /**
     * Customize all file(s) from a specified location with meta tag(s) to filter better the test stories
     * 
     * @param pathToDirectory
     *            - path to directory
     * @param customTag
     *            - tag(s) that should be added to the file(s)
     * 
     */
    public static void customizeStories(String pathToDirectory, String customTag) {
        File folder = new File(pathToDirectory);
        File[] directoryContent = folder.listFiles();
        if (directoryContent == null) {
            throw new IllegalArgumentException(String.format("No files in the specified directory %s", pathToDirectory));
        }
        int counter = 0;
        for (File file : directoryContent) {
            if (file.isFile()) {
                writeTagToStoryFile(customTag, file);
                counter++;
            }
        }
        String modifiedMessage = String.format("Modified %s file(s)", counter);
        LOG.info(modifiedMessage);
    }

    /**
     * Writes a String into a specified file
     * 
     * @param pathToFile
     *            - path to file
     * @param content
     *            - any string
     */
    public static void writeToFile(String pathToFile, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathToFile))) {
            bw.write(content);
        } catch (IOException e) {
            LOG.info(String.format("Cannot write content to file %s", pathToFile), e);
        }
    }

    /**
     * Writes a tag to story file after the line containing the scenario description
     * 
     * @param customTag
     *            - the name of the tag
     * @param file
     *            - path to the file
     */
    private static void writeTagToStoryFile(String customTag, File file) {
        String line;
        StringBuilder fileContentBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains("Scenario")) {
                    line = new StringBuilder().append(line).append(customTag).toString();
                }
                fileContentBuilder = fileContentBuilder.append(line).append("\n");
            }
            FileUtil.writeToFile(file.toString(), fileContentBuilder.toString());
        } catch (FileNotFoundException e) {
            LOG.info(String.format("File %s not found", file), e);
        } catch (IOException e1) {
            LOG.info(String.format("Cannot read the content of the file %s", file), e1);
        }
    }

}
