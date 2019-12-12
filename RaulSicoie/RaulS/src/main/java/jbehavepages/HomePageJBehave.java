package jbehavepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.DataFromPropertyFile;
import utils.WebElementHelper;

import static org.junit.Assert.assertEquals;

public class HomePageJBehave extends LoadableComponent {

    private WebDriver driver;
    private WebElementHelper helper;
    private DataFromPropertyFile dataFromPropertyFile;

    public HomePageJBehave(WebDriver driver) {
        this.driver = driver;
        helper = new WebElementHelper(driver);
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    public void goToBasePage() {
        driver.get(dataFromPropertyFile.getTheInternetBasePage());
    }

    @Override
    protected void load() {
        driver.get(dataFromPropertyFile.getTheInternetBasePage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(dataFromPropertyFile.getTheInternetBasePage(), driver.getCurrentUrl());
    }
}
