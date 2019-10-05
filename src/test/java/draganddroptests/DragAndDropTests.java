package draganddroptests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.DragAndDropPage;
import pages.WelcomePage;

import static org.testng.Assert.assertTrue;

public class DragAndDropTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void dragAToBTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Drag and Drop Link
        DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();

        // Drag box A and drop it on box B
        dragAndDropPage.dragAtoB();

        // Verify correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

        String columnBText = dragAndDropPage.getColumnBText();
        assertTrue(columnBText.equals("A"), "Column A header should be B, but it is: " + columnBText);
    }
}
