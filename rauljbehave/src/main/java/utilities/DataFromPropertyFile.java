package utilities;

public class DataFromPropertyFile {

    private static final String ENV_PROPERTIES_FILENAME = "emag";
    private final ReadProperties envProperties = new ReadProperties(ENV_PROPERTIES_FILENAME);
    private final String chromeDriverLocationWin = envProperties.getProperty("chrome.driver.location");

    private final String emagPage = envProperties.getProperty("emag.page");
    private final String emagLoginPage = envProperties.getProperty("emag.login.page");
    private final String emagCartPage = envProperties.getProperty("emag.cart.page");
    private final String emagUserHomePage = envProperties.getProperty("emag.user.page");
    private final String emagFavoritesPage = envProperties.getProperty("emag.favorites.page");

    private final String userEmail = envProperties.getProperty("emag.user.email");
    private final String userPassword = envProperties.getProperty("emag.user.password");

    private final String userPersonalDataPath = envProperties.getProperty("emag.user.personaldata.location");

    public static String getEnvPropertiesFilename() {
        return ENV_PROPERTIES_FILENAME;
    }

    public ReadProperties getEnvProperties() {
        return envProperties;
    }

    public String getChromeDriverLocationWin() {
        return chromeDriverLocationWin;
    }

    public String getEmagPage() {
        return emagPage;
    }

    public String getEmagLoginPage() {
        return emagLoginPage;
    }

    public String getEmagCartPage() {
        return emagCartPage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getEmagFavoritesPage() {
        return emagFavoritesPage;
    }

    public String getEmagUserHomePage() {
        return emagUserHomePage;
    }

    public String getUserPersonalDataPath() {
        return userPersonalDataPath;
    }
}
