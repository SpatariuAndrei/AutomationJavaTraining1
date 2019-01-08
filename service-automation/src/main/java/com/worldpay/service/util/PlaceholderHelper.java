package com.worldpay.service.util;

import com.worldpay.service.constants.TestDataConstants;
import com.worldpay.service.entities.SharedData;
import pl.jalokim.propertiestojson.object.AbstractJsonType;
import pl.jalokim.propertiestojson.object.BooleanJsonType;
import pl.jalokim.propertiestojson.object.StringJsonType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceholderHelper {
    private SharedData share;
    private TestDataUtil testDataUtil;
    private static final String QUOTES = "\"";

    public PlaceholderHelper(SharedData share) {
        this.share = share;
        testDataUtil = new TestDataUtil(share);
    }

    /**
     * Replace all the placeholders with their actual value, if there is none, the null value is returned and the other resolvers are used.
     *
     * @param propertyValue
     */
    public AbstractJsonType processPlaceholder(String propertyValue) {

        String newPropertyValue = propertyValue;

        if (newPropertyValue.contains(TestDataConstants.Placeholder.AUTO_CAPTURE))
            if (share.getTestData().containsKey(TestDataConstants.Property.AUTO_CAPTURE))
                return new BooleanJsonType(share.getTestData().getBoolean(TestDataConstants.Property.AUTO_CAPTURE));

        if (newPropertyValue.contains(TestDataConstants.Placeholder.CURRENT_DATE))
            newPropertyValue = newPropertyValue.replace(TestDataConstants.Placeholder.CURRENT_DATE, testDataUtil.getCurrentDate());

        if ((newPropertyValue.substring(0, 1).contains(QUOTES)
                && (newPropertyValue.substring(newPropertyValue.length() - 1)).contains(QUOTES))) {
            newPropertyValue = newPropertyValue.substring(1, propertyValue.length() - 1);
        }
        if (newPropertyValue.matches(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_DAYS))
            newPropertyValue = replaceDate(newPropertyValue, TestDataConstants.Placeholder.CURRENT_DATE_PLUS_DAYS);

        if (newPropertyValue.matches(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_MONTHS))
            newPropertyValue = replaceDate(newPropertyValue, TestDataConstants.Placeholder.CURRENT_DATE_PLUS_MONTHS);

        if (newPropertyValue.matches(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_YEARS))
            newPropertyValue = replaceDate(newPropertyValue, TestDataConstants.Placeholder.CURRENT_DATE_PLUS_YEARS);

        if (newPropertyValue == propertyValue)
            return null;
        else
            return new StringJsonType(newPropertyValue);
    }

    /**
     * Handle all the date related placehoders
     */
    public String replaceDate(String property, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(property);
        matcher.find();
        Integer number = Integer.valueOf(matcher.group(1));
        if (regexPattern == TestDataConstants.Placeholder.CURRENT_DATE_PLUS_DAYS)
            return matcher.replaceAll(testDataUtil.getCurrentDatePlusDays(number));
        if (regexPattern == TestDataConstants.Placeholder.CURRENT_DATE_PLUS_MONTHS)
            return matcher.replaceAll(testDataUtil.getCurrentDatePlusMonths(number));
        if (regexPattern == TestDataConstants.Placeholder.CURRENT_DATE_PLUS_YEARS)
            return matcher.replaceAll(testDataUtil.getCurrentDatePlusYears(number));
        else return null;
    }
}
