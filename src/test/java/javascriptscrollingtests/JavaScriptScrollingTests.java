package javascriptscrollingtests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.*;

public class JavaScriptScrollingTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void testScrollToTable() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Large & Deep DOM Link
        LargeAndDeepDomPage largeAndDeepDomPage = welcomePage.clickLargeAndDeepDomLink();

        // Scroll to table
        largeAndDeepDomPage.scrollToTable();
    }

    @Test(groups = { "smokeTests" })
    public void testScrollToFifthParagraph() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Infinite Scroll Link
        InfiniteScrollPage infiniteScrollPage = welcomePage.clickInfiniteScrollLink();

        // Scroll to 5 paragraphs
        infiniteScrollPage.scrollToParagraph(5);
    }
}
