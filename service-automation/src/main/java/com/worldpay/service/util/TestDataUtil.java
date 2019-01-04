package com.worldpay.service.util;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.configuration.CompositeConfiguration;

import pl.jalokim.propertiestojson.util.PropertiesToJsonConverter;

public class TestDataUtil {
    
    /**
     * Builds the JSON request from the testData
     * 
     * @param testData
     * @return
     */
    public static String createJsonFromTestData(CompositeConfiguration testData) {
        final Map<String, String> testDataMap = testDataToMap(testData);
        return new PropertiesToJsonConverter().convertToJson(testDataMap);
    }

    /**
     * Converts a CompositeConfiguration object to a Map, so that it can be transformed afterwards in a JSON request
     * 
     * @param testData
     * @return
     */
    private static Map<String, String> testDataToMap(CompositeConfiguration testData) {
        final ListOrderedMap<String, String> testDataMap = new ListOrderedMap<>();
        for (final Iterator<String> it = testData.getKeys(); it.hasNext();) {
            final String key = it.next();
            testDataMap.put(testDataMap.size(), key, testData.getString(key));
        }
        return testDataMap;
    }

}
