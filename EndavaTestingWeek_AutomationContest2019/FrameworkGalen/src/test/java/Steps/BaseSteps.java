package Steps;

import Help.HelperMethods;
import Help.ShareData;
import Pages.AccountPage;
import Pages.BasePage;
import Pages.BlogListPage;
import Pages.HomePage;
import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.model.LayoutReport;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BaseSteps extends Steps {

    ShareData share;
    HelperMethods functions;

    //Constructor
    public BaseSteps(ShareData share) {
        this.share = share;
        functions = new HelperMethods(share.driver);
    }


    //Steps
    @Given("I prepare a report for $path with Galen for $device")
    @When("I prepare a report for $path with Galen for $device")
    @Then("I prepare a report for $path with Galen for $device")
    public void prepareReports(@Named("path") String path,@Named("device") String device) throws IOException {
        String pageReport = path+"Report.gspec";
        functions.prepareReport(pageReport,device);
    }

    @Given("I check for other elements on $path for $device")
    @When("I check for other elements on $path for $device")
    @Then("I check for other elements on $path for $device")
    public void prepareExtraReports(@Named("path") String path,@Named("device") String device) throws IOException {

        String pageReport = path+"ExtraReport.gspec";
        extraReports(device, path, pageReport);

    }

    @Given("Site was opened in resolution: $width and $height")
    public void displayResolutionBrowser(@Named("width") String width,@Named("height") String height)
    {
        setResolution(width,height);
    }

    @Then("I generate reports for $testName for all devices and resolutions specified")
    public void generateAllReports(@Named("testName") String testName)
    {
        generateReports(testName);
    }
















    public void generateReports(String testName)
    {
        for(Map.Entry<String, List<GalenTestInfo>> entry : functions.getTestsMappedByPage().entrySet()) {
            try {
                functions.getHtmlReportBuilder().build(entry.getValue(),
                        "target/galen-reports/"+testName+"/" + entry.getKey());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setResolution(String width,String height)
    {
        Integer newWidth=Integer.parseInt(width);
        Integer newHeight=Integer.parseInt(height);
        if(!((newWidth.equals(2560)) || (newHeight.equals(2560))))
        {
            share.driver.manage().window().setSize(new Dimension(newWidth, newHeight));
        }
    }

    public void extraReports(String device,String path, String pageReport) throws IOException {
        HomePage homePage = new HomePage(share.driver);
        AccountPage accountPage = new AccountPage(share.driver);
        BlogListPage blogListPage = new BlogListPage(share.driver);
        if ((device.equals("mobile") && (path.equals("homePage")))) {
            homePage.clickNavBar();
            functions.prepareReport(pageReport, device);
        }
        if (device.equals("mobile")) {
            if((path.equals("blogListPage") || (path.equals("blogPage"))))
            {
                blogListPage.clickBlogNavBar();
                functions.prepareReport(pageReport, device);
            }
        }
        if ((device.equals("desktop") || (device.equals("tablet")))) {
            if (path.equals("accountPage")) {
                accountPage.clickUsername();
                functions.prepareReport(pageReport, device);
            }
        }
        if ((device.equals("mobile") && (path.equals("accountPage")))) {
            accountPage.clickUsernameWithSignUp();
            functions.prepareReport(pageReport, device);
        }
        String checkURL = share.driver.getCurrentUrl();
        if (checkURL.contains("/blog/")) {
            String[] newURL = checkURL.split("/blog/");
            if (newURL.length > 1) {
                String secondPart = newURL[1];
                if (secondPart.length() > 0) {
                    share.driver.navigate().to("https://www.lambdatest.com/");
                }
            }
        }
    }
}
