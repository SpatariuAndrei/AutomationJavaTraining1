package google;

import base.FirefoxTests;
import jdk.jfr.DataAmount;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.google.SearchResultsPage;

import javax.xml.namespace.QName;

import java.lang.reflect.Method;

import static org.testng.Assert.assertEquals;

public class GoogleSearchTests extends FirefoxTests {

    @Test
    @Parameters({"author"})
    public void testSearchingOnGoogle(String author){
        String expectedValue = "endava";
        googleSearchPage.inputSearchBox(expectedValue);
        Reporter.log("The browser is open now");
        getFirefoxDriver().manage().window().maximize();;
        Reporter.log("The browser is maximized");
        SearchResultsPage searchResultsPage = googleSearchPage.pressEnter();
        Reporter.log("The search results are displayed");
        String actualValue = googleSearchPage.pressEnter().getResult();
        assertEquals(actualValue,expectedValue,"The searching after word failed");
    }
}
