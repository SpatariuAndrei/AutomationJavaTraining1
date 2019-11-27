package utils;

public class DataFromPropertyFile {

    //*********Variables*********
    private static final ReadProperties envProperties = new ReadProperties("credentials");
    private static final String baseURL = envProperties.getProperty("baseURL");
    private static final String authURL = envProperties.getProperty("authURL");
    private static final String secureAreaURL = envProperties.getProperty("secureAreaURL");
    private static final String emagHomePageURL = envProperties.getProperty("emagHomePageURL");
    private static final String loginPageURL = envProperties.getProperty("loginPageURL");

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

    public static String getEmagHomePageURL() {
        return emagHomePageURL;
    }

    public static  String getLoginURL() {
        return loginPageURL;
    }
}
