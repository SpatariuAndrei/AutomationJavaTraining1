package com.worldpay.service.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.worldpay.service.constants.TestDataConstants;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.configuration.CompositeConfiguration;

import com.worldpay.service.entities.SharedData;

import org.apache.commons.lang3.time.DateUtils;
import pl.jalokim.propertiestojson.resolvers.primitives.BooleanJsonTypeResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.NumberJsonTypeResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.ObjectFromTextJsonTypeResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.StringJsonTypeResolver;
import pl.jalokim.propertiestojson.util.PropertiesToJsonConverter;

public class TestDataUtil {
    
    private SharedData share;
    
    public TestDataUtil(SharedData share) {       
        this.share = share;        
    }
    
    /**
     * Builds the JSON request from the testData
     * 
     * @param testData
     * @return
     */
    public String createJsonFromTestData(CompositeConfiguration testData) {
        
        final Map<String, String> testDataMap = testDataToMap(testData);
        return new PropertiesToJsonConverter(new OwnCustomTypeResolver(share), new ObjectFromTextJsonTypeResolver(),new NumberJsonTypeResolver(), new BooleanJsonTypeResolver(),
                new StringJsonTypeResolver()).convertToJson(testDataMap);
        
    }

    /**
     * Converts a CompositeConfiguration object to a Map, so that it can be transformed afterwards in a JSON request
     * 
     * @param testData
     * @return
     */
    private Map<String, String> testDataToMap(CompositeConfiguration testData) {
        
        final ListOrderedMap<String, String> testDataMap = new ListOrderedMap<>();
        for (final Iterator<String> it = testData.getKeys(); it.hasNext();) {
            final String key = it.next();
            testDataMap.put(testDataMap.size(), key, testData.getString(key));
        }
        return testDataMap;
        
    }

    /**
     * Get current date in the format passed on by the property: date.format
     */
    public String getCurrentDate()
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     *Get current date plus the number of the days received as a parameter, in format passed on by the property: date.format
     */
    public String getCurrentDatePlusDays(int days)
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        date = DateUtils.addDays(date, days);
        return dateFormat.format(date);
    }
    /**
     *Get current date plus the number of the months received as a parameter, in format passed on by the property: date.format
     */
    public String getCurrentDatePlusMonths(int months)
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        date = DateUtils.addMonths(date, months);
        return dateFormat.format(date);
    }
    /**
     *Get current date plus the number of the years received as a parameter, in format passed on by the property: date.format
     */
    public  String getCurrentDatePlusYears(int years)
    {
        DateFormat dateFormat = new SimpleDateFormat(share.getTestData().getString(TestDataConstants.Property.DATE_FORMAT,"yyyy/MM/dd"));
        Date date = new Date();
        date = DateUtils.addYears(date, years);
        return dateFormat.format(date);
    }

}
