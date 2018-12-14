package com.worldpay.service.util;

import pl.jalokim.propertiestojson.object.AbstractJsonType;
import pl.jalokim.propertiestojson.resolvers.PrimitiveJsonTypesResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.PrimitiveJsonTypeResolver;

public class OwnCustomTypeResolver extends PrimitiveJsonTypeResolver<Object> {

    private static final String QUOTES = "\"";

    /*
     * (non-Javadoc) This method will return the string between quotes
     * 
     * @see pl.jalokim.propertiestojson.resolvers.primitives.PrimitiveJsonTypeResolver#returnConcreteValueWhenCanBeResolved(pl.jalokim.
     * propertiestojson.resolvers.PrimitiveJsonTypesResolver, java.lang.String)
     */
    @Override
    protected Object returnConcreteValueWhenCanBeResolved(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, String propertyValue) {
        if ((propertyValue.substring(0, 1).contains(QUOTES)
                && (propertyValue.substring(propertyValue.length() - 1, propertyValue.length())).contains(QUOTES))) {
            return propertyValue.substring(1, propertyValue.length() - 1);
        } else
            return null;
    }

    // For read properties from Map<String, Object>, Properties
    // AbstractJsonType should contains data parsed and provide implementation for "toStringJson()" method
    // To invoke concrete resolver every resolver will be check by method canResolveThisObject(Class<?>) in PrimitiveJsonTypeResolver.
    @Override
    public AbstractJsonType returnConcreteJsonType(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, Object propertyValue) {
        return new AbstractJsonType() {
            
            @Override
            public String toStringJson() {
                return propertyValue.toString();
            }
        };
    }
}
