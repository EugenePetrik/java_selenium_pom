package javascripterrorstests;

import base.TestUtilities;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.WelcomePage;

import java.util.List;

public class JavaScriptErrorsTests extends TestUtilities {

    @Test(groups = { "alertsTests", "smokeTests" })
    public void javascriptErrorsTest() {
        SoftAssert softAssert = new SoftAssert();

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on JavaScript onload event error link
        welcomePage.clickJavaScriptErrorsLink();

        // Get logs
        List<LogEntry> logs = getBrowserLogs();

        // Verifying there are no JavaScript errors in console
        for (LogEntry logEntry : logs) {
            if (logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }

        softAssert.assertAll();
    }
}
