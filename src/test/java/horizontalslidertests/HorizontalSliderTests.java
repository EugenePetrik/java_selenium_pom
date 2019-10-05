package horizontalslidertests;

import base.TestUtilities;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
import pages.WelcomePage;

import static org.testng.Assert.assertTrue;

public class HorizontalSliderTests extends TestUtilities {

    @Test
    public void sliderTest() {
        // Open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Click on Horizontal Slider link
        HorizontalSliderPage horizontalSliderPage = welcomePage.clickHorizontalSliderLink();

        // Slider value
        String value = "3.5";

        // Set slider value
        horizontalSliderPage.setSliderTo(value);

        // Verify slider value
        String sliderValue = horizontalSliderPage.getSliderValue();
        assertTrue(sliderValue.equals(value), "Range is not correct. It is: " + sliderValue);
    }
}
