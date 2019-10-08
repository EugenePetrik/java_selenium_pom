package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By logInButtonLocator = By.tagName("button");
    private By errorMessageLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Execute log in
     */
    public SecureAreaPage login(String username, String password) {
        log.info("Executing Positive Login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    /**
     * Execute log in with invalid data
     */
    public void negativeLogin(String username, String password) {
        log.info("Executing Negative Login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
    }

    /**
     * Wait for error message to be visible on the page
     */
    protected void waitForErrorMessage() {
        waitForVisibilityOf(errorMessageLocator, 5);
    }

    /**
     * Return text from error message
     */
    public String getErrorMessageText() {
        waitForErrorMessage();
        return find(errorMessageLocator).getText();
    }
}
