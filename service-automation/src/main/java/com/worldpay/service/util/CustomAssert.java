package com.worldpay.service.util;

import com.worldpay.service.constants.Constants;
import com.worldpay.service.entities.SharedData;

public class CustomAssert {
    
    private CustomAssert() {
        
    }
    
    /**
     * @return the reason having informations 
     * to debug easy the failed assertion
     */
    public static String buildFailureReason(SharedData share) {
        return String.format("request: %s %n response: %s %n",share.getTestData().getString(Constants.REQUEST), share.getResponse().asString());
    }
   
}
