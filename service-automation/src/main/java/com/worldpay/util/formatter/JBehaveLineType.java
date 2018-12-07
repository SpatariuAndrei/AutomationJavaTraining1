package com.worldpay.util.formatter;

import static com.worldpay.util.formatter.JBehaveConstant.STORY_COMMENT;
import static com.worldpay.util.formatter.JBehaveConstant.TABLE_COMMENT;

public enum JBehaveLineType {

    COMMENT, TABLE_ROW, EXAMPLES, NARRATIVE, SCENARIO, STEP;

    /**
     * Determines the type of the given line.
     * 
     * @param line
     *            - the type of the line should be on of the types defined in {@link #LineType()}
     * @param fileType
     *            - the type of the file the given line belongs to
     * @return the type of the line
     * @throws IllegalArgumentException
     *             if the line is of an unexpected type
     */
    public static JBehaveLineType get(String line, JBehaveFileType fileType) {
        if ((fileType == JBehaveFileType.STORY && line.startsWith(STORY_COMMENT)) || (fileType == JBehaveFileType.TABLE && line.startsWith(TABLE_COMMENT))) {
            return COMMENT;
        }
        if (line.startsWith("|")) {
            return TABLE_ROW;
        }
        if (line.startsWith("Examples:")) {
            return EXAMPLES;
        }
        if (line.startsWith("Narrative:")) {
            return NARRATIVE;
        }
        if (line.startsWith("Scenario:")) {
            return SCENARIO;
        }
        return STEP;
    }

}
