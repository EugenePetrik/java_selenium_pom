package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage extends BasePageObject {

    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private By bodyLocator = By.tagName("body");

    public NestedFramesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get Left Frame text
     */
    public String getLeftFrameText() {
        switchToFrameByName(topFrame);
        switchToFrameByName(leftFrame);
        String text = getFrameText();
        switchToParentFrame();              // Exit left to top
        switchToParentFrame();              // Exit top to main
        return text;
    }

    /**
     * Get Bottom Frame text
     */
    public String getBottomFrameText() {
        switchToFrameByName(bottomFrame);
        String text = getFrameText();
        switchToParentFrame();              // Exit top to main
        return text;
    }

    /**
     * Get Frame text
     */
    private String getFrameText() {
        return find(bodyLocator).getText();
    }
}
