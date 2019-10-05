package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePageObject {

    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Fill in Retrieve Password form
     */
    public EmailSentPage retrievePassword(String email) {
        log.info("Executing Retrieve Password with email [" + email + "]");
        type(email, emailField);
        click(retrievePasswordButton);
        return new EmailSentPage(driver, log);
    }
}
