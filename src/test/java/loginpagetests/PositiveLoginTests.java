package loginpagetests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.WelcomePage;

import static org.testng.Assert.*;

public class PositiveLoginTests extends TestUtilities {

    @Test(priority = 1, enabled = true, groups = { "positiveLoginTests", "smokeTests" })
    public void positiveLoginTest() {
        // Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Take screenshot
        takeScreenshot("WelcomePage opened");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // Take screenshot
        takeScreenshot("LoginPage opened");

        // Execute log in
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

        // Take screenshot
        takeScreenshot("SecureAreaPage opened");

        // Verification
        // New url
        assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // Log out button is visible
        assertTrue(secureAreaPage.isLogOutButtonVisible(), "Logout button is not visible");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);
    }
}
