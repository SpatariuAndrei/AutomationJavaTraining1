package com.worldpay.service.steps;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.When;

import com.worldpay.util.formatter.JBehaveFileType;
import com.worldpay.util.formatter.JBehaveFormatter;

public class JBehaveFormatterSteps {

    private static final String PATH_TO_RESOURCES = "src/main/resources";
    private static final Map<JBehaveFileType, String> defaultBasePaths;
    static {
        defaultBasePaths = new HashMap<>();
        defaultBasePaths.put(JBehaveFileType.STORY, PATH_TO_RESOURCES);
        defaultBasePaths.put(JBehaveFileType.TABLE, "");
    }

    /**
     * Formats all files of the given type, starting from the given path, recursively.
     * 
     * @param jBehaveFileType
     *            the type of the files to format, one of the types from {@link JBehaveFileType}
     * @param relativePath
     *            the starting point of the search for the files to format, relative to the base directory for the given JBehave file type
     */
    @When("I format $jBehaveFileType files in location $relativePath")
    public void formatJBehaveFiles(String jBehaveFileType, String relativePath) {
        JBehaveFileType fileType = JBehaveFileType.valueOf(jBehaveFileType.toUpperCase());
        String finalPath = defaultBasePaths.get(fileType) + (relativePath.startsWith(File.separator) ? relativePath : File.separator + relativePath);
        try {
            new JBehaveFormatter(finalPath).recursively().format(fileType);
        } catch (IOException e) {
            throw new AssertionError("Error while formatting files.", e);
        }
    }

}
