package com.worldpay.service.util;

import java.io.Writer;
import java.util.Map;

import org.jbehave.core.reporters.FreemarkerProcessor;

public class CustomisableFreemarkerProcessor extends FreemarkerProcessor {

    public CustomisableFreemarkerProcessor(){
        super();
    }

    public void process(String resource, Map<String, Object> dataModel, Writer writer){
        super.process(resource, updateDataModel(dataModel), writer);
    }

    private Map<String, Object> updateDataModel(Map<String, Object> dataModel) {
//        String server = PropertiesUtil.getAppBaseUri().substring(8);
        String server = "localhost";
        
        if(server != null){
            dataModel.put("server", server);
        }
        return null;
    }

}
