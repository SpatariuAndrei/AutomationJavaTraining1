package com.worldpay.service.constants;

public class TestDataConstants {
    
    private static final String ERROR_MESSAGE = "Static class";
    
    private TestDataConstants() {
        throw new IllegalAccessError(ERROR_MESSAGE);
    }
    
    public static class ServerDetails {
                
        public static final String CUSTOM_SERVER_VERSION = "custom.server.version";
        public static final String CUSTOM_SERVER_HOST = "custom.server.host";
        public static final String CUSTOM_SERVER_PORT = "custom.server.port";
        public static final String CUSTOM_SERVER_PROTOCOL = "custom.server.protocol";
        public static final String CUSTOM_SERVER_BASEPATH = "custom.server.basePath";
        
        public static final String SERVER_VERSION = "server.version";
        public static final String SERVER_HOST = "server.host";
        public static final String SERVER_PORT = "server.port";
        public static final String SERVER_PROTOCOL = "server.protocol";
        public static final String SERVER_BASEPATH = "server.basePath";
        
        public static final String SERVER_CUSTOM_PATH = "server.custom.path";
        public static final String SERVER_SUBJECT = "server.subject";
        public static final String SERVER_ENDPOINT = "server.endpoint";
        public static final String SLASH = "/";
        
        private ServerDetails() {
            throw new IllegalAccessError(ERROR_MESSAGE);
        }
    }
    
    public static class Json {
        
        public static final String JSON_SCHEMA = "json.schema";
        public static final String JSON_REQUEST = "json.request";
        public static final String JSON_REQUEST_PATH = "json.request.path";
        
        private Json() {
            throw new IllegalAccessError(ERROR_MESSAGE);
        }
        
    }

    public static class Placeholder {
        public static final String AUTO_CAPTURE = "#AUTO_CAPTURE#";
        public static final String CURRENT_DATE = "#CURRENT_DATE#";
        public static final String CURRENT_DATE_PLUS_DAYS = "#CURRENT_DATE\\+(\\d+)DAYS#";
        public static final String CURRENT_DATE_PLUS_MONTHS = "#CURRENT_DATE\\+(\\d+)MONTHS#";
        public static final String CURRENT_DATE_PLUS_YEARS = "#CURRENT_DATE\\+(\\d+)YEARS#";
    }

    public static class Property {
        public static final String DATE_FORMAT = "date.format";
        public static final String AUTO_CAPTURE = "autocapture";

    }
    
}
