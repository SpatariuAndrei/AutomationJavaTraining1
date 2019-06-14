package com.worldpay.util.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.worldpay.util.formatter.JBehaveConstant;

/**
 * Utility class used to format JBehave tables.<br>
 * A non white space only line belonging to a table is expected to start with "|" or "|--".<br>
 * All lines will be trimmed. Empty or whitespace only lines will be only trimmed.
 * <p>
 * <blockquote>
 * 
 * <pre>
 * i.e.
 * 
 * | col1 | a value |
 *     | c2 | hello |
 * 
 * | c3 | hello world |
 * |-- comment
 * | | no first |
 * | c5 |
 * 
 * to
 * 
 * | col1 | a value     |
 * | c2   | hello       |
 * 
 * | c3   | hello world |
 * |-- comment
 * |      | no first    |
 * | c5   |             |
 * </pre>
 * 
 * </blockquote>
 * <p>
 * 
 */
public class JBehaveTableFormatter {

    private static final String ARGUMENT_INDEX = "%1";
    private static final String ARGUMENT_TYPE = "s";
    private static final String RIGHT_PAD = "-";
    private static final String LENGTH = "$";

    private JBehaveTableFormatter() {
    }

    /**
     * Formats a table.
     * 
     * @param inputLines
     *            - the lines of the table
     * @return {@link List} of {@link String} representing the lines of the formatted table
     */
    public static List<String> formatTable(List<String> inputLines) {
        return formatTable(inputLines, 0, inputLines.size());
    }

    /**
     * Formats lines of a file that form a table.
     * 
     * @param inputLines
     *            - the lines of the file
     * @param startIndex
     *            - the starting index of the table in the lines
     * @param endIndex
     *            - the end index of the table in the lines, not including the line with the given index
     * @return {@link List} of {@link String} representing the lines of the file with the formatted table
     */
    public static List<String> formatTable(List<String> inputLines, int startIndex, int endIndex) {
        String[][] matrix = correctTable(inputLines, startIndex, endIndex);

        fixColumnWidths(matrix, getColumnWidths(matrix, startIndex, endIndex));

        List<String> formLines = new ArrayList<>(matrix.length - 1);
        for (int i = 0; i < matrix.length - 1; i++) {
            String line;
            if (matrix[i] != null) {
                line = JBehaveConstant.COLUMN_SEPARATOR;
                for (int j = 0; j < matrix[i].length; j++) {
                    line += " " + matrix[i][j] + " " + JBehaveConstant.COLUMN_SEPARATOR;
                }
            } else {
                line = inputLines.get(i);
            }
            formLines.add(line);
        }
        return formLines;
    }

    /**
     * Correct the table format and generate the table matrix.<br>
     * 1. add empty columns where needed to obtain the same number of columns on every row;<br>
     * 2. trim every line;<br>
     * 3. generate table matrix.
     * 
     * @return the matrix representation of the table
     * @throws IllegalArgumentException
     *             if the table is incorrect
     **/
    private static String[][] correctTable(List<String> inputLines, int startIndex, int endIndex) {
        // get column separator count of longest row (should be column count + 1)
        int columnSeparators = 0;
        for (int i = startIndex; i < endIndex; i++) {
            if (!skip(inputLines.get(i))) {
                int charCount = countAppearance(inputLines.get(i), JBehaveConstant.COLUMN_SEPARATOR);
                if (columnSeparators < charCount) {
                    columnSeparators = charCount;
                }
            }
        }
        // correct table and generate matrix
        String[][] matrix = new String[endIndex - startIndex + 1][];
        for (int i = startIndex; i < endIndex; i++) {
            String currentLine = inputLines.get(i).trim();
            if (!skip(currentLine)) {
                int missingColumnNo = columnSeparators - countAppearance(currentLine, JBehaveConstant.COLUMN_SEPARATOR);
                String toAdd = new String(new char[missingColumnNo]).replaceAll("\0", JBehaveConstant.COLUMN_SEPARATOR);
                currentLine += toAdd;

                matrix[i - startIndex] = currentLine.substring(1, currentLine.length() - 1).split(Pattern.quote(JBehaveConstant.COLUMN_SEPARATOR), -1);
                for (int j = 0; j < matrix[i - startIndex].length; j++) {
                    matrix[i - startIndex][j] = matrix[i - startIndex][j].trim();
                }
            }
            inputLines.set(i, currentLine);
        }
        matrix[endIndex - startIndex] = new String[] { String.valueOf(columnSeparators - 1) };
        return matrix;
    }

    private static boolean skip(String line) {
        if (line.startsWith(JBehaveConstant.TABLE_COMMENT) || line.isEmpty()) {
            return true;
        }
        if (line.startsWith(JBehaveConstant.COLUMN_SEPARATOR)) {
            return false;
        }
        throw new IllegalArgumentException("Incorrect table line: " + line);
    }

    private static int countAppearance(String line, String part) {
        return (line.length() - line.replace(part, "").length()) / part.length();
    }

    private static int[] getColumnWidths(String[][] matrix, int startIndex, int endIndex) {
        int[] columnWidths = new int[Integer.parseInt(matrix[endIndex - startIndex][0])];
        for (int j = 0; j < columnWidths.length; j++) {
            int maxCellLength = 1;
            int cellLength;
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i] != null && (cellLength = matrix[i][j].length()) > maxCellLength) {
                    maxCellLength = cellLength;
                }
            }
            columnWidths[j] = maxCellLength;
        }
        return columnWidths;
    }

    private static void fixColumnWidths(String[][] matrix, int[] columnWidths) {
        for (int j = 0; j < columnWidths.length; j++) {
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i] != null) {
                    matrix[i][j] = String.format(ARGUMENT_INDEX + LENGTH + RIGHT_PAD + columnWidths[j] + ARGUMENT_TYPE, matrix[i][j]);
                }
            }
        }
    }

}
