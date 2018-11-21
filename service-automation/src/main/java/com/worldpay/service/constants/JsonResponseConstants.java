package com.worldpay.service.constants;

public class JsonResponseConstants {

    private static final String ERROR_MESSAGE = "Static class";

    private JsonResponseConstants() {
        throw new IllegalAccessError(ERROR_MESSAGE);
    }

    public static class Response {
        public static final String BODY = "response";
        public static final String CODE = "code";
        public static final String RESPONSE_CODE = "response.code";
        public static final String RESPONSE_MESSAGE = "response.message";
        public static final String MESSAGE_BODY = "message";
        public static final String IDENTITY_MODE = "response.identifyMode";
        public static final String QUERY_ID = "response.queryId";

        private Response() {
            throw new IllegalAccessError(ERROR_MESSAGE);
        }
    }

}
