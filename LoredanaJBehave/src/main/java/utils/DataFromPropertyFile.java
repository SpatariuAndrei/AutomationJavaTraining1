package utils;

public class DataFromPropertyFile {

    //*********Variables*********
    private static final ReadProperties envProperties = new ReadProperties("credentials");
    private static final String baseURL = envProperties.getProperty("baseURL");
    private static final String browser = envProperties.getProperty("browser");
    private static final String so = envProperties.getProperty("so");
    private static final String email = envProperties.getProperty("email");
    private static final String password = envProperties.getProperty("password");
    private static final String favoritesPage = envProperties.getProperty("favoritesPage");

    //*********Methods*********
    public static String getBaseURL() {
        return baseURL;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getSo() {
        return so;
    }

    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getFavoritesPage() {
        return favoritesPage;
    }
}
