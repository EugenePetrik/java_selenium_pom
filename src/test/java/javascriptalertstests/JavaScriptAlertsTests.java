package javascriptalertstests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;
import pages.WelcomePage;

import static org.testng.Assert.*;

public class JavaScriptAlertsTests extends TestUtilities {

    @Test(groups = { "alertsTests", "smokeTests" })
    public void javascriptAlertTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JavaScript Alert button
        alertsPage.openJavaScriptAlert();

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click OK button
        alertsPage.acceptAlert();

        // Get Results text
        String result = alertsPage.getResultText();

        // Verifications
        // 1 - Alert text is expected
        assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");
        // 2 - Result text is expected
        assertTrue(result.equals("You successfuly clicked an alert"),
                "Result is not expected. \nShould be 'You successfully clicked an alert', but it is '" + result + "'");
    }

    @Test(groups = { "alertsTests", "smokeTests" })
    public void javascriptAcceptTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JavaScript Confirm button
        alertsPage.openJavaScriptConfirm();

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click OK button
        alertsPage.acceptAlert();

        // Get Results text
        String result = alertsPage.getResultText();

        // Verifications
        // 1 - Alert text is expected
        assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
        // 2 - Result text is expected
        assertTrue(result.equals("You clicked: Ok"),
                "Result is not expected. \nShould be 'You clicked: Ok', but it is '" + result + "'");
    }

    @Test(groups = { "alertsTests", "smokeTests" })
    public void javascriptDismissTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JavaScript Confirm button
        alertsPage.openJavaScriptConfirm();

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click Cancel button
        alertsPage.dismissAlert();

        // Get Results text
        String result = alertsPage.getResultText();

        // Verifications
        // 1 - Alert text is expected
        assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");
        // 2 - Result text is expected
        assertTrue(result.equals("You clicked: Cancel"),
                "Result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
    }

    @Test(groups = { "alertsTests", "smokeTests" })
    public void javascriptPromptTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JavaScript Prompt button
        alertsPage.openJavaScriptPrompt();

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's Eugene here");

        // Get Results text
        String result = alertsPage.getResultText();

        // Verifications
        // 1 - Alert text is expected
        assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");
        // 2 - Result text is expected
        assertTrue(result.equals("You entered: Hello Alert, it's Eugene here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result + "'");
    }
}
