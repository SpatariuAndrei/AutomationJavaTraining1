package jsAlerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

import static org.testng.Assert.assertEquals;

public class JSAlertTests extends BaseTests {

    @Test
    public void testAcceptAlert() {
        JavaScriptAlertsPage alertPage = homePage.clickJSAlertsPage();
        alertPage.triggerAlert();
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResult(), "You successfuly clicked an alert", "Result text incorrect");
    }

    @Test
    public void testConfrimAlert() {
        JavaScriptAlertsPage alertsPage = homePage.clickJSAlertsPage();
        alertsPage.triggerConfirm();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You clicked: Ok", "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert() {
        JavaScriptAlertsPage alertsPage = homePage.clickJSAlertsPage();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect");
    }

    @Test
    public void testSetInputInAlert() {
        JavaScriptAlertsPage alertsPage = homePage.clickJSAlertsPage();
        alertsPage.triggerPrompt();
        String text = "Sergiu te saluta!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Alert text incorect");
    }
}
