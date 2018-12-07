package com.worldpay.util.formatter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.worldpay.singleclick.util.FileUtil;
import com.worldpay.util.formatter.JBehaveFileType;

public class JBehaveFormatter {

    private static final Logger LOG = LoggerFactory.getLogger(JBehaveFormatter.class);

    public static final Charset CHARSET = StandardCharsets.UTF_8;

    private Path startPath;
    private boolean recursively;
    private boolean isFolder;

    /**
     * @param startPath
     *            the {@link String} representation of the path the formatting will start from; can be a file or folder
     * @throws IllegalArgumentException
     *             if the path is not a file or folder
     */
    public JBehaveFormatter(String startPath) {
        newStartPath(startPath);
    }

    /**
     * @param startPath
     *            the path the formatting will start from; can be a file or folder
     * @throws IllegalArgumentException
     *             if the path is not a file or folder
     */
    public JBehaveFormatter(Path startPath) {
        newStartPath(startPath);
    }

    /**
     * Sets a new start path for the formatter instance, so this can be reused.
     * 
     * @param startPath
     *            the {@link String} representation of the path the formatting will start from; can be a file or folder
     * @throws IllegalArgumentException
     *             if the path is not a file or folder
     */
    public final JBehaveFormatter newStartPath(String startPath) {
        return newStartPath(Paths.get(startPath));
    }

    /**
     * Sets a new start path for the formatter instance, so this can be reused.
     * 
     * @param startPath
     *            the path the formatting will start from; can be a file or folder
     * @return
     * @throws IllegalArgumentException
     *             if the path is not a file or folder
     */
    public final JBehaveFormatter newStartPath(Path startPath) {
        isFolder = Files.isDirectory(startPath);
        if (!isFolder && !Files.isRegularFile(startPath)) {
            throw new IllegalArgumentException("Given path was neither file nor folder: " + startPath);
        }
        LOG.info("Starting path for formatting is {} path: {}", isFolder ? "folder" : "file", startPath);
        this.startPath = startPath;
        recursively = false;
        return this;
    }

    /**
     * If called, makes the formatting recursive, entering sub-folders. If the set path is not a folder, this call will have no effect.
     */
    public JBehaveFormatter recursively() {
        recursively = true;
        LOG.info("Formatting recursively.");
        return this;
    }

    /**
     * Format JBehave file(s) of the given type.
     * 
     * @param fileType
     *            the type of the files to format, serves as a filter; if null, all types of JBehave files will be formatted
     * @throws IOException
     */
    public void format(JBehaveFileType fileType) throws IOException {
        if (fileType == null) {
            LOG.info("Formatting JBehave file(s) of all type.");
        } else {
            LOG.info("Formatting JBehave file(s) of type: {}", fileType);
        }
        if (isFolder) {
            formatFilesFromDirectory(startPath, fileType);
        } else {
            formatFile(startPath, fileType);
        }
        LOG.info("Done formatting.");
    }

    /**
     * Format files starting from a given directory, recursively or not.
     * 
     * @param startDirectory
     *            must be a directory
     * @param recursively
     *            call with true to enter sub-folders, or with false to stop at first level
     */
    private void formatFilesFromDirectory(Path startDirectory, JBehaveFileType fileTypeToFormat) throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(startDirectory)) {
            for (Path directoryEntry : directoryStream) {
                if (Files.isRegularFile(directoryEntry)) {
                    formatFile(directoryEntry, fileTypeToFormat);
                } else if (recursively && Files.isDirectory(directoryEntry)) {
                    formatFilesFromDirectory(directoryEntry, fileTypeToFormat);
                } else {
                    LOG.info("Skipping path: {}", directoryEntry);
                }
            }
        }
    }

    private void formatFile(Path file, JBehaveFileType fileTypeToFormat) throws IOException {
        JBehaveFileType actualFileType = JBehaveFileType.get(file);

        if (actualFileType != null && (fileTypeToFormat == null || fileTypeToFormat == actualFileType)) {
            LOG.info("Formatting file: {}", file);
            List<String> inputLines = FileUtil.readFileWithoutMultipleEmptyLines(file);
            if (actualFileType == JBehaveFileType.TABLE) {
                Files.write(file, JBehaveTableFormatter.formatTable(inputLines), CHARSET);
            } else if (actualFileType == JBehaveFileType.STORY) {
                JBehaveStoryFormatter.formatStory(file, inputLines, actualFileType);
            }
        } else {
            LOG.info("Skipping file: {}", file);
        }
    }

}
