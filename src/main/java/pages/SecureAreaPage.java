package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/secure";

    private By logOutButton = By.cssSelector("a[href='/logout']");
    private By message = By.id("flash");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get URL variable from PageObject
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * Verification if logOutButton is visible on the page
     */
    public boolean isLogOutButtonVisible() {
        return find(logOutButton).isDisplayed();
    }

    /**
     * Return text from success message
     */
    public String getSuccessMessageText() {
        return find(message).getText();
    }
}
