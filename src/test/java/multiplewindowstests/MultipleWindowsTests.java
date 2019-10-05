package multiplewindowstests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.MultipleWindowsPage;
import pages.NewWindowPage;
import pages.WelcomePage;

import static org.testng.Assert.assertTrue;

public class MultipleWindowsTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void newWindowTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on MultipleWindows link
        MultipleWindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();

        // Click 'Click Here' link to open new window
        windowsPage.openNewWindow();

        // Find and switch to new window page
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        // Verification
        // New page contains expected text in source
        String pageSource = newWindowPage.getCurrentPageSource();
        assertTrue(pageSource.contains("New Window"), "New page source doesn't contain expected text");
    }
}
