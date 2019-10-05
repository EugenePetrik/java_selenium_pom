package hoverstests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.HoversPage;
import pages.WelcomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoversTests extends TestUtilities {

    @Test(groups = { "smokeTests" })
    public void user2ProfileTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Hovers link
        HoversPage hoversPage = welcomePage.clickHoversLink();

        // Open User 2 profile
        hoversPage.openUserProfile(2);

        // Verify correct user profile opened
        assertTrue(hoversPage.getCurrentUrl().contains("/users/2"),
                "URL of opened page is not expected User 2 page URL");
    }

    @Test(groups = { "smokeTests" })
    public void hoverTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Hovers link
        HoversPage hoversPage = welcomePage.clickHoversLink();

        // Open User 1 profile
        HoversPage.FigureCaption caption = hoversPage.hoverOverFigure(1);
        // var caption = hoversPage.hoverOverFigure(1);

        // Verifications
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle(), "name: user1", "Caption title incorrect");
        assertEquals(caption.getLinkText(), "View profile", "Caption link text incorrect");
        assertTrue(caption.getLink().contains("/users/1"), "Link incorrect");
    }
}
