package loginpagetests;

import base.TestUtilities;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.WelcomePage;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTests extends TestUtilities {

    @Parameters({ "username", "password", "expectedErrorMessage" })
    @Test(priority = 1)
    public void negativeLoginTest(String username, String password, String expectedErrorMessage) {
        log.info("Starting Negative Login Test");

        // Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // Execute negative login
        loginPage.negativeLogin(username, password);

        // Verification
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }
}
