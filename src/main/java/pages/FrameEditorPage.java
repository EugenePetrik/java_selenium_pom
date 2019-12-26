package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameEditorPage extends BasePageObject {

    private By editorLocator = By.id("tinymce");
    private By frameLocator = By.tagName("iframe");

    public FrameEditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get text from TinyMCE WYSIWYG Editor
     */
    public String getEditorText() {
        switchToFrameByLocator(frameLocator);
        String text = find(editorLocator).getText();
        log.info("Text from TinyMCE WYSIWYG Editor: " + text);
        return text;
    }
}
