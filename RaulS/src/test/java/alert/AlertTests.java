package alert;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    private static final String TEXT = "TAU rocks!";

    @Test
    public void testAcceptJsAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alertClickToAccept();
        assertEquals(alertsPage.getAlertResult(), "You successfuly clicked an alert");
    }

    @Test
    public void testGetTextFromConfirmAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alertConfirmGetText();
        alertsPage.alertClickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testSetInputInPromptAlert() {
        AlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        alertsPage.alertSetPromptInput(TEXT);
        alertsPage.alertClickToAccept();
        assertEquals(alertsPage.getAlertResult(), "You entered:9 " + TEXT, "Result incorrect");
    }
}
