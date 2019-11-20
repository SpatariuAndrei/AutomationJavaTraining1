package utils;

public class DataFromPropertyFile {

    //*********Variables*********
    private static final ReadProperties envProperties = new ReadProperties("credentials");
    private static final String baseURL = envProperties.getProperty("baseURL");
    private static final String authURL = envProperties.getProperty("authURL");
    private static final String secureAreaURL = envProperties.getProperty("secureAreaURL");

    //*********Methods*********
    public static String getBaseURL() {
        return baseURL;
    }

    public static String getAuthURL() {
        return authURL;
    }

    public static String getSecureAreaURL() {
        return secureAreaURL;
    }
}
