package com.worldpay.service.util;

import com.worldpay.service.entities.SharedData;
import org.apache.commons.lang3.time.DateUtils;
import pl.jalokim.propertiestojson.object.AbstractJsonType;
import pl.jalokim.propertiestojson.object.StringJsonType;
import pl.jalokim.propertiestojson.resolvers.PrimitiveJsonTypesResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.PrimitiveJsonTypeResolver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OwnCustomTypeResolver extends PrimitiveJsonTypeResolver<Object> {

    public OwnCustomTypeResolver(SharedData share) {
        this.share = share;
    }

    private static final String QUOTES = "\"";
    private SharedData share;

    @Override
    protected Object returnConcreteValueWhenCanBeResolved(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, String propertyValue) {
        return processProperty(propertyValue);
    }

    @Override
    public AbstractJsonType returnConcreteJsonType(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, Object propertyValue) {
        return new StringJsonType(propertyValue.toString());
    }

    private Object processProperty(String propertyValue) {
        String newPropertyValue = propertyValue;
        if (newPropertyValue.contains(Constants.Placeholder.CURRENT_DATE))
            newPropertyValue = newPropertyValue.replace(Constants.Placeholder.CURRENT_DATE, getCurrentDate());

        if ((newPropertyValue.substring(0, 1).contains(QUOTES)
                && (newPropertyValue.substring(newPropertyValue.length() - 1, newPropertyValue.length())).contains(QUOTES))) {
            newPropertyValue = newPropertyValue.substring(1, propertyValue.length() - 1);
        }
        return null;
    }

    private String getCurrentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(Constants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        return dateFormat.format(date);
    }

    private String getCurrentDatePlusDays(int days)
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(Constants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        date = DateUtils.addDays(date, days);
        return dateFormat.format(date);
    }

    private String getCurrentDatePlusMonths(int months)
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(Constants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        date = DateUtils.addMonths(date, months);
        return dateFormat.format(date);
    }

    private String getCurrentDatePlusYears(int years)
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(Constants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        date = DateUtils.addYears(date, years);
        return dateFormat.format(date);
    }

}
