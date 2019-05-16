package Help;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class HelperMethods {

    WebDriver driver;
    private Map<String, List<GalenTestInfo>> testsMappedByPage = new TreeMap<>();
    private HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
    LayoutReport layoutReport=null;

    public HelperMethods (WebDriver driver)
    {
        this.driver=driver;
    }

    //Functions
    //Generate report for a specified page
    public void reportUpdate(LayoutReport layoutReport, String name,String device) {

            if(!testsMappedByPage.containsKey(name)) {
                testsMappedByPage.put(name, new ArrayList<GalenTestInfo>());
            }
            try {
                GalenTestInfo test = GalenTestInfo.fromString("Test automation with Galen: " + name + " report on " + device + " device");
                test.getReport().layout(layoutReport, "Verify the entire fields of the " + name + " on " + device + " device");
                testsMappedByPage.get(name).add(test);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    public String generateReportName(String text)
    {
        String newText1=text.split("gspecFiles")[1];
        String newText2=newText1.split("Report")[0];
        String finalText=newText2.substring(1,newText2.length());
        return finalText;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }


    public void clickWebElement(WebElement element,WebDriver driver) {
        waitExplicit(element, driver);
        element.click();
    }


    public void fillWebElement(WebElement element, WebDriver driver,String value) {
        waitExplicit(element, driver);
        element.clear();
        element.sendKeys(value);
    }


    public void hoverWebElement(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }


    public void waitExplicit(WebElement element, WebDriver driver) {
        new WebDriverWait(driver, 3000).until(ExpectedConditions.visibilityOf(element));
    }


    public void validatePage(String expected, WebDriver driver) {
        {
            String actual = driver.getTitle();
            Assert.assertEquals("Values are not the same",expected,actual);
        }
    }

    //WaitExtreme
    public void waitExtreme()
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<GalenTestInfo>> getTestsMappedByPage() {
        return testsMappedByPage;
    }

    public HtmlReportBuilder getHtmlReportBuilder() {
        return htmlReportBuilder;
    }

    public void prepareReport(String namePath,String device) throws IOException {
        String pathReport = "src/test/resources/gspecFiles/"+namePath+"";
        //LayoutReport layoutReport=null;
        layoutReport = Galen.checkLayout(driver, pathReport, Arrays.asList(device));
        String nameTheReport=generateReportName(pathReport);
        reportUpdate(layoutReport,nameTheReport,device);
    }

    //Generate random email
    public String generateEmail()
    {
        String randomValues=""+System.currentTimeMillis();
        String newEmail=""+randomValues.substring(0,4);
        String component=helpGenerator();
        newEmail=newEmail+"@"+component+".com";
        return  newEmail;
    }

    public String helpGenerator()
    {
        String password="a b c d e f g h i j k l m n";
        List<String> passwordValues= Arrays.asList(password.split(" "));
        int sizeList=passwordValues.size();
        String newPassword="";
        int contor=0;
        while(newPassword.length()<6)
        {
            Random rand = new Random();
            int x = rand.nextInt(sizeList);
            String currentElement=passwordValues.get(x);
            newPassword=newPassword+currentElement;
            contor=contor+1;
        }
        return  newPassword;
    }


}
