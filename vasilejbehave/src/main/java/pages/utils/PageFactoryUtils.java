package pages.utils;

import org.openqa.selenium.WebDriver;
import pages.HomePage;


public class PageFactoryUtils {
    private WebDriver driver;
    private HomePage homePage;

    public PageFactoryUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * to be able to reuse the same page object instance across multiple steps classes
     * @return
    */
    public HomePage  getBasePage(){
        return homePage != null ? homePage : new HomePage(driver);
    }

}
