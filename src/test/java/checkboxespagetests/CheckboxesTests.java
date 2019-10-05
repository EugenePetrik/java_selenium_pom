package checkboxespagetests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.CheckboxesPage;
import pages.WelcomePage;

import static org.testng.Assert.*;

public class CheckboxesTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void selectingTwoCheckboxesTest() {
        log.info("Starting Selecting Two Checkboxes Test");

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select All Checkboxes
        checkboxesPage.selectAllCheckboxes();

        // Verify all checkboxes are checked
        assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes are checked");
    }
}
