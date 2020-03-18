package base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    private RemoteWebDriver driver;
    private Capabilities chromeCapabilities = DesiredCapabilities.chrome();
    private Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
    private RemoteWebDriver chrome;
    private RemoteWebDriver firefox;


    @Test
    public void goToPage() throws MalformedURLException {
        chrome = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
        firefox = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxCapabilities);

        // run against chrome
        chrome.get("https://www.google.com");
        System.out.println("Chrome browser title: "+ chrome.getTitle());

        // run against firefox
        firefox.get("https://www.google.com");
        System.out.println("Firefox browser title: "+firefox.getTitle());

    }

    @AfterClass
    public void tearDown(){
        chrome.quit();
        firefox.quit();
    }

    public static void main(String args[]) throws MalformedURLException {
        BaseTest test = new BaseTest();
        test.goToPage();
    }

}
