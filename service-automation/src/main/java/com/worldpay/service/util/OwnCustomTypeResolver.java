package com.worldpay.service.util;

import com.worldpay.service.constants.TestDataConstants;
import com.worldpay.service.entities.SharedData;
import org.apache.commons.lang3.time.DateUtils;
import pl.jalokim.propertiestojson.object.*;
import pl.jalokim.propertiestojson.resolvers.PrimitiveJsonTypesResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.PrimitiveJsonTypeResolver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OwnCustomTypeResolver extends PrimitiveJsonTypeResolver<String> {

    public OwnCustomTypeResolver(SharedData share) {
        this.share = share;
        testDataUtil = new TestDataUtil(share);
    }

    private static final String QUOTES = "\"";
    private SharedData share;
    private TestDataUtil testDataUtil;

    @Override
    protected String returnConcreteValueWhenCanBeResolved(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, String propertyValue) {
        return processProperty(propertyValue);
    }

    @Override
    public AbstractJsonType returnConcreteJsonType(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, String propertyValue){
        return new StringJsonType(propertyValue);
    }


    /**
     * Replace all the placeholders with their actual value, if there is none, the null value is returned and the other resolvers are used.
     * @param propertyValue
     */
    private String processProperty(String propertyValue) {
        String newPropertyValue = propertyValue;
        if (newPropertyValue.contains(TestDataConstants.Placeholder.CURRENT_DATE))
            newPropertyValue = newPropertyValue.replace(TestDataConstants.Placeholder.CURRENT_DATE, testDataUtil.getCurrentDate());

        if ((newPropertyValue.substring(0, 1).contains(QUOTES)
                && (newPropertyValue.substring(newPropertyValue.length() - 1)).contains(QUOTES))) {
            newPropertyValue = newPropertyValue.substring(1, propertyValue.length() - 1);
        }
        if (newPropertyValue.matches(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_DAYS))
        {
            Pattern pattern = Pattern.compile(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_DAYS);
            Matcher matcher = pattern.matcher(newPropertyValue);
            matcher.find();
            Integer number = Integer.valueOf(matcher.group(1));
            newPropertyValue = matcher.replaceAll(testDataUtil.getCurrentDatePlusDays(number));
        }
        if (newPropertyValue.matches(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_MONTHS))
        {
            Pattern pattern = Pattern.compile(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_MONTHS);
            Matcher matcher = pattern.matcher(newPropertyValue);
            Integer number = Integer.valueOf(matcher.group(1));
            newPropertyValue = matcher.replaceAll(testDataUtil.getCurrentDatePlusMonths(number));
        }
        if (newPropertyValue.matches(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_YEARS))
        {
            Pattern pattern = Pattern.compile(TestDataConstants.Placeholder.CURRENT_DATE_PLUS_YEARS);
            Matcher matcher = pattern.matcher(newPropertyValue);
            Integer number = Integer.valueOf(matcher.group(1));
            newPropertyValue = matcher.replaceAll( testDataUtil.getCurrentDatePlusYears(number));
        }
        if (newPropertyValue == propertyValue)
            return null;
        else
            return newPropertyValue;
    }



}
