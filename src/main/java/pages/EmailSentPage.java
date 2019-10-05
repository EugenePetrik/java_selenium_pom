package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage extends BasePageObject {

    private By contentArea = By.id("content");

    public EmailSentPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Return text from success message
     */
    public String getMessage() {
        return find(contentArea).getText();
    }
}
