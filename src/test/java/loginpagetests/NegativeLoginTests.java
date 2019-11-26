package loginpagetests;

import base.CsvDataProviders;
import base.TestUtilities;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.WelcomePage;

import java.util.Map;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTests extends TestUtilities {

    @Test(priority = 1, enabled = true, groups = { "negativeLoginTests", "smokeTests" },
            dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeLoginTest(Map<String, String> testData) {
        // Data
        String number = testData.get("number");
        String username = testData.get("username");
        String password = testData.get("password");
        String expectedErrorMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting Negative Login Test # " + number + " for " + description);

        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

        // Execute negative login
        loginPage.negativeLogin(username, password);

        // Verify correct error message
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
                        + expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
    }
}
