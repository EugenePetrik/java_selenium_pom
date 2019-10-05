package forgotpasswordpagetests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTest {

    @Test(groups = { "smokeTests" })
    public void testRetrievePassword() {
        log.info("Starting Retrieve Password Test");

        // Open Main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Forgot Password link
        ForgotPasswordPage forgotPasswordPage = welcomePage.clickForgotPasswordLink();

        // Execute retrieve password
        EmailSentPage emailSentPage = forgotPasswordPage.retrievePassword("tau@example.com");

        // Verification
        // Successful retrieve password message
        assertEquals(emailSentPage.getMessage(), "Your e-mail's been sent!", "Message is incorrect");
    }
}
