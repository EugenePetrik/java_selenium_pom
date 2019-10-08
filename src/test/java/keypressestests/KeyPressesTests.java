package keypressestests;

import base.TestUtilities;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class KeyPressesTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void pressKeyTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Key Presses link
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        // Push keyboard key
        keyPressesPage.pressKey(Keys.ENTER);

        // Get Results text
        String result = keyPressesPage.getResultText();

        // Verify that result text is expected
        assertTrue(result.equals("You entered: ENTER"),
                "Result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
    }

    @Test(groups = { "smokeTests" })
    public void pressKeyWithActionsTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Key Presses link
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        // Push keyboard key
        keyPressesPage.pressKeyWithActions(Keys.SPACE);

        // Get Results text
        String result = keyPressesPage.getResultText();

        // Verify that result text is expected
        assertTrue(result.equals("You entered: SPACE"),
                "Result is not expected. \nShould be 'You entered: SPACE', but it is '" + result + "'");
    }

    @Test(groups = { "smokeTests" })
    public void pressBackspaceTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Key Presses link
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        // Push keyboard key
        keyPressesPage.enterText("A" + Keys.BACK_SPACE);

        // Verify that result text is expected
        assertEquals(keyPressesPage.getResultText(), "You entered: BACK_SPACE");
    }

    @Test(groups = { "smokeTests" })
    public void pressPiTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Key Presses link
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        // Push keyboard key
        keyPressesPage.enterPi();

        // Verify that result text is expected
        assertEquals(keyPressesPage.getResultText(), "You entered: 4");
    }
}
