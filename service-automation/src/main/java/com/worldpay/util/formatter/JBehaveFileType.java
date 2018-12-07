package com.worldpay.util.formatter;

import java.nio.file.Path;

import org.apache.commons.io.FilenameUtils;

public enum JBehaveFileType {

    STORY, TABLE;

    /**
     * Determines the JBehave file type of the file on the given path.
     * 
     * @param path
     *            the path to the file
     * @return the JBehave file type of the file, or null of the file is not one of the JBehave file types
     */
    public static JBehaveFileType get(Path path) {
        String extension = FilenameUtils.getExtension(path.getFileName().toString()).toUpperCase();
        for (JBehaveFileType jBehaveFileType : values()) {
            if (jBehaveFileType.name().equals(extension)) {
                return jBehaveFileType;
            }
        }
        return null;
    }

}
