package com.worldpay.service.util;

import com.worldpay.service.entities.SharedData;
import pl.jalokim.propertiestojson.object.AbstractJsonType;
import pl.jalokim.propertiestojson.resolvers.PrimitiveJsonTypesResolver;
import pl.jalokim.propertiestojson.resolvers.primitives.PrimitiveJsonTypeResolver;

public class OwnCustomTypeResolver extends PrimitiveJsonTypeResolver<AbstractJsonType> {

    public OwnCustomTypeResolver(SharedData share) {
        placeHolderHelper = new PlaceHolderHelper(share);
    }

    private PlaceHolderHelper placeHolderHelper;

    @Override
    protected AbstractJsonType returnConcreteValueWhenCanBeResolved(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, String propertyValue) {
        return placeHolderHelper.processPlaceholder(propertyValue);
    }

    @Override
    public AbstractJsonType returnConcreteJsonType(PrimitiveJsonTypesResolver primitiveJsonTypesResolver, AbstractJsonType propertyValue) {
        return propertyValue;
    }
}
