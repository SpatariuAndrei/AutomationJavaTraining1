package com.worldpay.util.formatter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.worldpay.util.formatter.JBehaveFileType;
import com.worldpay.util.formatter.JBehaveLineType;

public class JBehaveStoryFormatter {

    private static final int LINES_AT_START_OF_STORY = 0;
    private static final int LINES_AT_END_OF_STORY = 2;
    private static final int LINES_BEFORE_FIRST_SCENARIO = 0;
    private static final int LINES_BETWEEN_SCENARIOS = 2;
    private static final int LINES_AFTER_NARRATIVE_TITLES = 2;
    private static final int LINES_AFTER_SCENARIO_TITLES = 1;
    private static final int LINES_BEFORE_EXAMPLE = 1;
    private static final int LINES_BEFORE_EXAMPLE_TABLE = 1;

    private JBehaveStoryFormatter() {
    }

    /**
     * Formats a story.
     * 
     * @param inputLines
     *            the lines of the story
     * @throws IOException
     */
    public static void formatStory(Path file, List<String> inputLines, JBehaveFileType fileType) throws IOException {
        inputLines = removeStandardEmptyLines(inputLines);
        inputLines.add("");

        List<String> resultLines = new ArrayList<>(inputLines.size());

        List<String> table = new ArrayList<>();
        boolean inTableSequence = false;
        for (String newLine : inputLines) {
            JBehaveLineType newLineType = JBehaveLineType.get(newLine, fileType);
            if (newLineType == JBehaveLineType.TABLE_ROW || (fileType == JBehaveFileType.TABLE && newLineType == JBehaveLineType.COMMENT)) {
                if (!inTableSequence) {
                    inTableSequence = true;
                }
                table.add(newLine);
            } else {
                if (inTableSequence) {
                    inTableSequence = false;
                    resultLines.addAll(JBehaveTableFormatter.formatTable(table));
                    table.clear();
                }
                resultLines.add(newLine);
            }
        }

        boolean firstScenario = true;
        BufferedWriter fileOut = Files.newBufferedWriter(file, JBehaveFormatter.CHARSET);
        if (fileType == JBehaveFileType.STORY) {
            addEmptyLine(fileOut, LINES_AT_START_OF_STORY);
        }

        boolean hadNarrative = false;
        for (String newLine : resultLines) {
            JBehaveLineType newLineType = JBehaveLineType.get(newLine, fileType);
            if (newLineType == JBehaveLineType.NARRATIVE) {
                hadNarrative = true;
            }
            if (newLineType == JBehaveLineType.SCENARIO) {
                if (firstScenario) {
                    firstScenario = false;
                    if (hadNarrative) {
                        addEmptyLine(fileOut, LINES_AFTER_NARRATIVE_TITLES);
                    } else {
                        addEmptyLine(fileOut, LINES_BEFORE_FIRST_SCENARIO);
                    }
                } else {
                    addEmptyLine(fileOut, LINES_BETWEEN_SCENARIOS);
                }
                fileOut.write(newLine);
                addEmptyLine(fileOut, LINES_AFTER_SCENARIO_TITLES);
            } else if (newLineType == JBehaveLineType.EXAMPLES) {
                addEmptyLine(fileOut, LINES_BEFORE_EXAMPLE);
                fileOut.write(newLine);
                addEmptyLine(fileOut, LINES_BEFORE_EXAMPLE_TABLE);
            } else {
                fileOut.write(newLine);
            }
            fileOut.newLine();
        }
        if (fileType == JBehaveFileType.STORY) {
            addEmptyLine(fileOut, LINES_AT_END_OF_STORY - 2);
        }
        fileOut.close();
    }

    private static List<String> removeStandardEmptyLines(List<String> lines) {
        List<String> guardedLines = new LinkedList<>(lines);
        // add guard lines
        guardedLines.add(0, "");
        guardedLines.add("");
        List<String> result = new ArrayList<>();

        for (int i = 1; i < guardedLines.size() - 1; i++) {
            if (guardedLines.get(i).isEmpty()) {
                JBehaveLineType prevType = JBehaveLineType.get(guardedLines.get(i - 1), JBehaveFileType.STORY);
                JBehaveLineType nextType = JBehaveLineType.get(guardedLines.get(i + 1), JBehaveFileType.STORY);
                if ((prevType == JBehaveLineType.STEP || prevType == JBehaveLineType.COMMENT)
                        && (nextType == JBehaveLineType.STEP || nextType == JBehaveLineType.COMMENT)) {
                    result.add(guardedLines.get(i));
                }
            } else {
                result.add(guardedLines.get(i));
            }
        }
        return result;
    }

    private static void addEmptyLine(BufferedWriter fileOut, int lineCount) throws IOException {
        for (int newLineCount = 0; newLineCount < lineCount; newLineCount++) {
            fileOut.newLine();
        }
    }

}
