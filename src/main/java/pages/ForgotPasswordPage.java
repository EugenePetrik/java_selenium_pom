package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePageObject {

    private By emailFieldLocator = By.id("email");
    private By retrievePasswordButtonLocator = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Fill in Retrieve Password form
     */
    public EmailSentPage retrievePassword(String email) {
        log.info("Executing Retrieve Password with email [" + email + "]");
        type(email, emailFieldLocator);
        click(retrievePasswordButtonLocator);
        return new EmailSentPage(driver, log);
    }
}
