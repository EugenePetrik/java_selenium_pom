package contextmenutests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.ContextMenuPage;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void contextMenuTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Context Menu link
        ContextMenuPage contextMenuPage = welcomePage.clickContextMenuLink();

        // Perform right mouse button click
        contextMenuPage.rightClickInBox();

        // Get popup text
        String message = contextMenuPage.getPopUpText();

        // Accept alert
        contextMenuPage.acceptPopUp();

        // Verifications
        assertEquals(message, "You selected a context menu", "Popup message incorrect");
    }
}
