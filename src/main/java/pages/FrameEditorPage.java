package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameEditorPage extends BasePageObject {

    private By editorLocator = By.id("tinymce");
    private By frameLocator = By.tagName("iframe");
    private String editorIframeId = "mce_0_ifr";
    private By textAreaLocator = By.id("tinymce");
    private By decreaseIndentButtonLocator = By.cssSelector("#mceu_12 button");

    public FrameEditorPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /**
     * Get text from TinyMCE WYSIWYG Editor
     */
    public String getEditorText() {
        switchToFrame(frameLocator);
        String text = find(editorLocator).getText();
        log.info("Text from TinyMCE WYSIWYG Editor: " + text);
        return text;
    }

    /**
     * Clear text area
     */
    public void clearTextArea() {
        switchToEditArea();
        find(textAreaLocator).clear();
        switchToParentFrame();
    }

    /**
     * Set text area
     */
    public void setTextArea(String text) {
        switchToEditArea();
        type(text, textAreaLocator);
        switchToParentFrame();
    }

    /**
     * Get text from Editor
     */
    public String getTextFromEditor() {
        switchToEditArea();
        String text = find(textAreaLocator).getText();
        switchToParentFrame();
        return text;
    }

    /**
     * Decrease Indention
     */
    public void decreaseIndention() {
        click(decreaseIndentButtonLocator);
    }

    /**
     * Switch to Edit Area
     */
    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }
}
