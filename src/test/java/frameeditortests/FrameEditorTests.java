package frameeditortests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.FrameEditorPage;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FrameEditorTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void defaultEditorValueTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Scroll to the bottom
        welcomePage.scrollToBottom();

        // Click on WYSIWYG Editor link
        FrameEditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();

        // Get default editor text
        String editorText = editorPage.getEditorText();

        // Verify that new page contains expected text in source
        assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }

    @Test(groups = { "smokeTests" })
    public void wysiwygTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Scroll to the bottom
        welcomePage.scrollToBottom();

        // Click on WYSIWYG Editor link
        FrameEditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();

        // Clear text area
        editorPage.clearTextArea();

        // Fill in some text
        String text1 = "Hello ";
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        // Verify that text filled in properly
        assertEquals(editorPage.getTextFromEditor(), text1 + text2,
                "Text from editor is incorrect");
    }
}
