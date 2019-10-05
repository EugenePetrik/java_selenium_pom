package framestests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.FramesPage;
import pages.NestedFramesPage;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;

public class FramesTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void frameTextTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Frames link
        FramesPage framesPage = welcomePage.clickFramesLink();

        // Click on Nested Frames link
        NestedFramesPage nestedFramesPage = framesPage.clickNestedFrames();

        // Verification
        assertEquals(nestedFramesPage.getLeftFrameText(), "LEFT", "Left frame text incorrect");
        assertEquals(nestedFramesPage.getBottomFrameText(), "BOTTOM", "Bottom frame text incorrect");
    }
}
