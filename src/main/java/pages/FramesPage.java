package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePageObject {

    private By nestedFramesLocator = By.linkText("Nested Frames");

    public FramesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Open Nested Frames page
     */
    public NestedFramesPage clickNestedFrames() {
        click(nestedFramesLocator);
        return new NestedFramesPage(driver, log);
    }
}
