package utils;

public class DataFromPropertyFile {

    //Env variables
    private static final String ENV_PROPERTIES_FILENAME = "theinternet.test";
    private final ReadProperties envProperties = new ReadProperties(ENV_PROPERTIES_FILENAME);
    private final String geckoDriverLocationWin = envProperties.getProperties("chrome.driver.location");

    //User credentials
    private final String userName = envProperties.getProperties("theinternet.user.username");
    private final String userPassword = envProperties.getProperties("theinternet.user.password");

    //URLs
    private final String theInternetBasePage = envProperties.getProperties("theinternet.base.page");
    private final String getTheInternetLoginPage = envProperties.getProperties("theinternet.login.page");

    public String getGeckoDriverLocationWin() {
        return geckoDriverLocationWin;
    }

    public String getTheInternetBasePage() {
        return theInternetBasePage;
    }

    public String getGetTheInternetLoginPage() {
        return getTheInternetLoginPage;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }


}
