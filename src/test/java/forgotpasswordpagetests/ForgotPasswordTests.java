package forgotpasswordpagetests;

import base.CsvDataProviders;
import base.TestUtilities;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;
import pages.WelcomePage;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends TestUtilities {

    @Test(groups = { "smokeTests" }, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void retrievePasswordTest(Map<String, String> testData) {
        // Data
        String number = testData.get("number");
        String email = testData.get("email");
        String expectedMessage = testData.get("expectedMessage");
        String description = testData.get("description");

        log.info("Starting RetrievePasswordTest # " + number + " for " + description);

        // Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Forgot Password link
        ForgotPasswordPage forgotPasswordPage = welcomePage.clickForgotPasswordLink();

        // Execute retrieve password
        EmailSentPage emailSentPage = forgotPasswordPage.retrievePassword(email);

        // Verification
        // Successful retrieve password message
        assertEquals(emailSentPage.getMessage(), expectedMessage, "Message is incorrect");
    }
}
