package com.worldpay.service.constants;

public class HttpConstants {

    private static final String ERROR_MESSAGE = "Static class";

    private HttpConstants() {
        throw new IllegalAccessError(ERROR_MESSAGE);
    }
    
    public static class Config {
        
        public static final String HTTP_CONNECTION_TIMEOUT_PARAM = "http.connection.timeout";
        public static final String HTTP_SOCKET_TIMEOUT_PARAM = "http.socket.timeout";

        private Config() {
            throw new IllegalAccessError(ERROR_MESSAGE);
        }    
               
    }
    
    public static class Headers {
        
        public static final String HEADER_NAME = "headerName";
        public static final String HEADER_VALUE = "headerValue";
        
        private Headers() {
            throw new IllegalAccessError(ERROR_MESSAGE);
        }    
          
    }

    public static class RequestMethods {

        public static final String DELETE = "delete";
        public static final String GET = "get";
        public static final String HEAD = "head";
        public static final String OPTIONS = "options";
        public static final String PUT = "put";
        public static final String POST = "post";

        private RequestMethods() {
            throw new IllegalAccessError(ERROR_MESSAGE);
        }

    }   
}
