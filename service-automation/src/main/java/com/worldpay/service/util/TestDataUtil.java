package com.worldpay.service.util;

import com.worldpay.service.entities.SharedData;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.configuration.CompositeConfiguration;
import pl.jalokim.propertiestojson.resolvers.primitives.BooleanJsonTypeResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.NumberJsonTypeResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.ObjectFromTextJsonTypeResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.StringJsonTypeResolver;
import pl.jalokim.propertiestojson.util.PropertiesToJsonConverter;

import java.util.Iterator;
import java.util.Map;

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
        return new PropertiesToJsonConverter(new OwnCustomTypeResolver(share), new ObjectFromTextJsonTypeResolver(), new NumberJsonTypeResolver(), new BooleanJsonTypeResolver(),
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
        for (final Iterator<String> it = testData.getKeys(); it.hasNext(); ) {
            final String key = it.next();
            testDataMap.put(testDataMap.size(), key, testData.getString(key));
        }
        return testDataMap;

    }
}
