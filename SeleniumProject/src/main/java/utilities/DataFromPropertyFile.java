package utilities;

public class DataFromPropertyFile {

    //Env variables
    private static final String ENV_PROPERTIES_FILENAME = "emag.test";
    private final ReadProperties envProperties = new ReadProperties(ENV_PROPERTIES_FILENAME);
    private final String geckoDriverLocationWin = envProperties.getProperty("gecko.driver.location");


    // URLs
    private final String emagLoginPage= envProperties.getProperty("emag.login.page");
    private final String emagCartPage = envProperties.getProperty("emag.cart.page");




    // User credentials
    private final String userEmail = envProperties.getProperty("emag.user.email");
    private final String userPassword = envProperties.getProperty("emag.user.password");

    public String getGeckoDriverLocationWin() {
        return geckoDriverLocationWin;
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
}
