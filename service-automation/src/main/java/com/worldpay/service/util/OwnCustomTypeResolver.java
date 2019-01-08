package com.worldpay.service.util;

import com.worldpay.service.entities.SharedData;
import pl.jalokim.propertiestojson.object.AbstractJsonType;
import pl.jalokim.propertiestojson.resolvers.PrimitiveJsonTypesResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.PrimitiveJsonTypeResolver;

public class OwnCustomTypeResolver extends PrimitiveJsonTypeResolver<AbstractJsonType> {

    public OwnCustomTypeResolver(SharedData share) {
        this.share = share;
        placeholderHelper = new PlaceholderHelper(share);
    }


    private SharedData share;
    private PlaceholderHelper placeholderHelper;

    @Override
    protected AbstractJsonType returnConcreteValueWhenCanBeResolved(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, String propertyValue) {
        return placeholderHelper.processPlaceholder(propertyValue);
    }

    @Override
    public AbstractJsonType returnConcreteJsonType(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, AbstractJsonType propertyValue) {
        return propertyValue;
    }
}
