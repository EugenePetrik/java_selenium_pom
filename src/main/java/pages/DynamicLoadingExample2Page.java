package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingExample2Page extends BasePageObject {

    private By startButtonLocator = By.cssSelector("#start button");
    private By loadedTextLocator = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Click on Start button
     */
    public void clickStart() {
        click(startButtonLocator);
        waitForPresenceOf(loadedTextLocator);
    }

    /**
     * Verification if Start button is visible on the page
     */
    public boolean isStartButtonDisplayed() {
        return find(startButtonLocator).isDisplayed();
    }

    /**
     * Get loaded text
     */
    public String getLoadedText() {
        return find(loadedTextLocator).getText();
    }
}
