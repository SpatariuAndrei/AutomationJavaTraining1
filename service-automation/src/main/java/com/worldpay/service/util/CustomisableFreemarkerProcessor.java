package com.worldpay.service.util;

import java.io.Writer;
import java.util.Map;

import org.jbehave.core.reporters.FreemarkerProcessor;
import com.worldpay.service.environment.Environment;

public class CustomisableFreemarkerProcessor extends FreemarkerProcessor {

    Environment ENV;

    public CustomisableFreemarkerProcessor() {
        super();
    }

    @Override
    public void process(String resource, Map<String, Object> dataModel, Writer writer) {
        super.process(resource, updateDataModel(dataModel), writer);
    }

    private Map<String, Object> updateDataModel(Map<String, Object> dataModel) {
        String server = ENV.get().getServerHost();
        String version = ENV.get().getServerVersion();
        
        if (server != null) {
            dataModel.put("server", server);
            dataModel.put("version", version);
        }
        
        return dataModel;
    }

}
