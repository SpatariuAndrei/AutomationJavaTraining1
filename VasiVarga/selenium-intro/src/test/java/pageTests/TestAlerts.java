package pageTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import setUpTest.SetUp;

public class TestAlerts extends SetUp {

    @Test
    public void testAlerts(){

        var signUpPage = homePage.clickSkipButton();
        signUpPage.hoverOverMenuItem("SwitchTo").clickMenuItem("Alerts");

        AlertsPage alertsPage = new AlertsPage(driver);

        alertsPage.clickTab("Alert with OK");

        alertsPage.clickTab("Alert with OK & Cancel");

        alertsPage.clickTab("Alert with textbox");

        alertsPage.clickTab("Alert with OK");
        alertsPage.clickButton("click the button to display an alert box:");
        alertsPage.acceptAlert();

        alertsPage.clickTab("Alert with OK & Cancel");
        alertsPage.clickButton("click the button to display a confirm box");
        alertsPage.dismissAlert();

        alertsPage.clickTab("Alert with Textbox");
        alertsPage.clickButton("click the button to demonstrate the prompt box");
        String nameToType = "Vasi";
        alertsPage.typeToPromptBox(nameToType);
        alertsPage.acceptAlert();

        By message = By.id("demo1");

        Assert.assertEquals(driver.findElement(message).getText(),"Hello "+nameToType+ " How are you today");

    }


}
